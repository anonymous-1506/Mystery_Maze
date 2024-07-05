package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.player;
import tile.MazeGenerator;
import tile.Tilemanager;

import javax.swing.JPanel;



public class gamepanel extends JPanel implements Runnable {
	//FPS
	int FPS = 60;
//	//player positional variables:
//	int x = 100;
//	int y = 100;
//	int dx = 4;
//	int dy = 4;
//	//end
	public final int tile_size = 48; // retro 16 x 16 tiles
	final int scale = 1; // scales the 16 x 16
	public final int tile_size_net = tile_size * scale;
	public final int Columns = 12;
	public final int Rows = 15;
	public final int screen_width = Columns*tile_size_net; //768 px
	public final int screen_height = Rows*tile_size_net; //576 px
	
	KeyInput KeysI = new KeyInput();
	public MazeGenerator maze = new MazeGenerator(this);
	Tilemanager tilem = new Tilemanager(this);
	Thread gameThread;
	public Collisions collision = new Collisions(this);
	
	public player player = new player(this,KeysI);

	
	
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
				System.out.println("FPS:"+drawer);
				drawer = 0;
				timer = 0;
			}
		
		}
	}
	
	public void update() {
		player.update();
		System.out.println("rows:"+maze.rows+" cols:"+maze.cols);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tilem.draw(g2,maze);
		
		
		player.draw(g2);
		g2.dispose();
	}
	
}
