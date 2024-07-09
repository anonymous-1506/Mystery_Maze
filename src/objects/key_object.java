package objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.entity;
import main.gamepanel;

public class key_object {
	gamepanel gp;
	
	public int X;
	public int Y;
	public boolean taken = false;
	public boolean inStock = false;
	public BufferedImage asset;
	public Rectangle SolidArea = new Rectangle();
	public key_object(gamepanel gp)
	{
		this.gp = gp;
		int x,y;
		do
		{
			x =(int) (1 + Math.random()*12);
			y = (int)(1 +Math.random()*20);
		}
		while(gp.maze.getMazeBool(x, y));
		X = y * gp.tile_size_net;
		Y = x * gp.tile_size_net;
		try
		{
			asset = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
		}catch(IOException e)
		{
			e.getStackTrace();
		}
		SolidArea.x = X;
		SolidArea.y = Y;
		SolidArea.height = 24;
		SolidArea.width = 24;
	}
	public void update(entity entity)
	{	
		//Updating the entity solid area coordinates:
		int newx =  entity.SolidArea.x;
		int newy =  entity.SolidArea.y;
		entity.SolidArea.x = entity.SolidArea.x + entity.x;
		entity.SolidArea.y = entity.SolidArea.y + entity.y;
		if(entity.SolidArea.intersects(this.SolidArea))
		{
			if(!taken)
			{
			gp.playSE(1);
			this.taken = true;
			this.inStock = true;
			gp.tilem.tiles[3].collision = false;
			}
		}
		entity.SolidArea.x = newx;
		entity.SolidArea.y = newy;
	}
	public void draw(Graphics2D g2, gamepanel gp)
	{	
		if(!this.taken)
			
		{		
			g2.drawImage(asset, X, Y, 3*gp.tile_size_net/4,3*gp.tile_size_net/4,null);
		}
	}
}
