package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamepanel;

public class bomb_obj {
	gamepanel gp;
	int X = 0;
	int Y = 0;
	boolean deployed = false;
	boolean used = false;
	boolean blast = false;
	BufferedImage image ;
	BufferedImage image1 ;
	
	public bomb_obj(gamepanel gp)
	{
		this.gp = gp;
		X = gp.player.x;
		Y = gp.player.y;
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/bomb.png"));
			image1 = ImageIO.read(getClass().getResourceAsStream("/objects/shadow.png"));
		}catch(IOException e)
		{
			e.getStackTrace();
		}
		deployed = true;
	}
	public void draw(Graphics2D g2,gamepanel gp)
	{
		if(deployed)
		{
			if(!used)
			{	
				g2.drawImage(image1, X, Y + 24, gp.tile_size_net, gp.tile_size_net, null);
				g2.drawImage(image, X, Y, gp.tile_size_net, gp.tile_size_net, null);
			}
		}
	}
}

