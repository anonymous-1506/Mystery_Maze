package objects;

import java.awt.Graphics2D;

import main.gamepanel;

public class bomb_placer {
	gamepanel gp;
	public bomb_placer(gamepanel gp)
	{
		this.gp = gp;
	}
	public void bomb_update()
	{	
		int c = gp.KeysI.bomb;
//		System.out.println("bomb "+c);
		if(c !=  0)
		{
			
		if(gp.bomb_count < gp.bomb_stock)
		{	
				switch(c) {
				case 1:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"up");
					gp.KeysI.bomb = 0;
					break;
				case 2:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"down");
					gp.KeysI.bomb = 0;
					break;
				case 3:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"left");
					gp.KeysI.bomb = 0;
					break;
				case 4:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"right");
					gp.KeysI.bomb = 0;
					break;
						}
				gp.bomb_count++;
		}
		}
		
		for(int i = 0; i < gp.bomb_stock;i ++)
		{
			if(gp.bombs[i] != null)
			{	
				if(gp.bombs[i].bomb_timer == 2)
				{
					gp.playSE(5);
					gp.bombs[i].used = true;
					gp.maze.flasher(gp.bombs[i].X, gp.bombs[i].Y);
					gp.bombs[i].bomb_timer = 3;
				}
				if(gp.bombs[i].bomb_timer == 4)
				{
					gp.maze.grounded(gp.bombs[i].X, gp.bombs[i].Y);
					gp.bombs[i] = null;
				}
			}
		}
//			System.out.println("no:of bombs: "+gp.bomb_count);
	}
	
	public void draw(Graphics2D g2)
	{
		for(int i = 0; i < 3; i++)
		{
			if(gp.bombs[i] != null)
			{
				gp.bombs[i].draw(g2, gp);
			}
		}
	}
}