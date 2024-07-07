package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseUI {
	gamepanel gp;
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;
	Font base = new Font("Arial",Font.PLAIN,20);
	String text = " : ";
	public BaseUI(gamepanel gp) {
		this.gp = gp;
		try
		{
			image1 = ImageIO.read(getClass().getResourceAsStream("/objects/bomb.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/title_art.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
		}catch(IOException e)
		{
			e.getStackTrace();
		}
	}
	public void draw(Graphics2D g2)
	{
		int total = gp.maze.cols * 48;
		g2.setFont(base);
		g2.setColor(Color.WHITE);
		g2.drawImage(image2, total/2 - 98, 0, 195, 48, null);
		g2.drawImage(image1, total - 120, 10, 24, 24, null);
		g2.drawString(" : "+(3 - gp.bomb_count), total - 90, 30);
		if(gp.keyobj.inStock)
		{
			g2.drawImage(image3, total - 180, 10, 24, 24, null);
		}
	}
}
