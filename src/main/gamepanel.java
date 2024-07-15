package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.player;
import objects.bomb_obj;
import objects.bomb_placer;
import objects.key_object;
import tile.MazeGenerator;
import tile.Tilemanager;

import javax.swing.JPanel;



public class gamepanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//FPS
	int FPS = 60;

	public final int tile_size = 48; // retro 16 x 16 tiles
	final int scale = 1; // scales the 16 x 16
	public final int tile_size_net = tile_size * scale;
	public final int Columns = 20;
	public final int Rows = 15;
	public final int screen_width = Columns*tile_size_net; //768 px
	public final int screen_height = Rows*tile_size_net; //576 px
	
	public Game_over gover = new Game_over(this);
	public Menu gmenu = new Menu(this);
	public BaseUI baseui = new BaseUI(this);
	public KeyInput KeysI = new KeyInput();
	Thread gameThread;
	public Collisions collision = new Collisions(this);
	
	public Sound sound = new Sound();
	public MazeGenerator maze = new MazeGenerator(this);
	public Tilemanager tilem = new Tilemanager(this);
	public key_object keyobj = new key_object(this);
	public bomb_obj[] bombs = new bomb_obj[3];
	public int bomb_count = 0;
	public bomb_placer bombset = new bomb_placer(this);
	public player player = new player(this,KeysI);
	int a = (int)(1+Math.random()*20);
	// GAME PLAYER TIMER:
	public int TIME = 60;
	public int Player_timer = TIME;
	//COINS:
	public int coin_score = 0;
	public boolean change = false;
	public int bomb_stock = 3;
	
	public gamepanel()
	{
		this.setPreferredSize(new Dimension(screen_width, screen_height));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeysI);
		this.setFocusable(true);
	}

	
	public void start(){
		gameThread = new Thread(this);
		gameThread.start();
		}
	

	@Override
	public void run() {
		
		//Time logic 
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		double lasttime = System.nanoTime();
		double currenttime;
		long timer = 0;
		int drawer = 0;
		
		//the main game loop
		while(gameThread != null)
		{	
			
			currenttime = System.nanoTime();
			delta += (currenttime - lasttime)/drawInterval;
			timer += (currenttime - lasttime);
			lasttime = currenttime;
			
			
			if (delta > 1) {
			//1 UPDATE THE VARIABLES
			update();
			//2 DRAW EVERYTHING
			repaint();
			delta--;
			drawer += 1;
			}
			
			if(timer >= 1000000000)
			{	
				if(KeysI.gamestate == 1)
				{
					Player_timer = Player_timer - 1;
					for(int i = 0; i < bomb_stock; i++)
					{
						if(bombs[i] != null)
						{
							bombs[i].bomb_timer++;
						}
					}
				}
				System.out.println("FPS:"+drawer);
				drawer = 0;
				timer = 0;
			}
		
		}
	}
	
	public void update() {
		
		
		if(Player_timer == 0)
		{
			KeysI.gamestate = 4;
			gover.over_case = 1;
			Player_timer = TIME;
			
		}
		switch(KeysI.gamestate)
		{
		case 0:
			gmenu.update();
			break;
		case 1:
			if(change)
			{
				Player_timer = TIME;
				coin_score = 0;
				maze = new MazeGenerator(this);
				tilem = new Tilemanager(this);
				keyobj = new key_object(this);
				bombs = new bomb_obj[3];
				bomb_count = 0;
				bombset = new bomb_placer(this);
				player = new player(this,KeysI);
				change = false;
			}
			bombset.bomb_update();
			player.update();
			keyobj.update(player);
			tilem.update(player);
			maze.updateCoin();
			break;
		case 2:
			break;
		case 3:
			gmenu.update();
			break;
		case 4:
			gover.update();
			break;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		switch(KeysI.gamestate)
		{
		case 0:
			gmenu.draw(g2);
			break;
		case 1:
			tilem.draw(g2,maze);
			keyobj.draw(g2, this);
			bombset.draw(g2);
			player.draw(g2);
			//BASE UI:
			baseui.draw(g2);
			break;
		case 2:
			tilem.draw(g2,maze);
			keyobj.draw(g2, this);
			for(int i = 0; i < 3; i++)
			{
				if(bombs[i] != null)
				{
					bombs[i].draw(g2, this);
				}
			}
			player.draw(g2);
			//BASE UI:
			baseui.draw(g2);
			break;
		case 3:
			gmenu.draw(g2);
			break;
		case 4:
			gover.draw(g2);
			break;
		}
		
		g2.dispose();
	}
	
	public void PlayMusic(int i)
	{
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	public void StopMusic()
	{
		sound.stop();
	}
	public void playSE(int i)
	{
		sound.setFile(i);
		sound.play();
	}
}
