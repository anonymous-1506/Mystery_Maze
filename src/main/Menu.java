package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Menu {
	gamepanel gp;
	int button = 1;
	Font font1 = new  Font("Arial",Font.PLAIN,20);
	Font Retro1,Retro2,Indic;
	BufferedImage player,image1,image2;
	
	public Menu(gamepanel gp)
	{
		this.gp = gp;
		try
		{
			player = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			image1 = ImageIO.read(getClass().getResourceAsStream("/objects/GOAL.png"));
//			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/gameover_1.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		try 
		{
			InputStream get = getClass().getResourceAsStream("/fonts/MP16SC.TTF");
			Retro1 = Font.createFont(Font.TRUETYPE_FONT,get);
			get = getClass().getResourceAsStream("/fonts/MP16TO1.TTF");
			Retro2 = Font.createFont(Font.TRUETYPE_FONT,get);
			get = getClass().getResourceAsStream("/fonts/ANANDA NEPTOUCH 2.TTF");
			Indic = Font.createFont(Font.TRUETYPE_FONT,get);
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(FontFormatException e2)
		{
			e2.printStackTrace();
		}
	}
	public void update()
	{	
		int current = button;
		if(gp.KeysI.ups)
		{	
			gp.playSE(4);
			if(current == 1)
			{	
				button = 3;
				gp.KeysI.ups = false;
			}
			else if(current == 2)
			{
				button = 1;
				gp.KeysI.ups = false;
			}
			else if(current == 3)
			{
				button = 2;
				gp.KeysI.ups = false;
			}
		}
		if(gp.KeysI.downs)
		{
			gp.playSE(4);
			if(current == 1)
			{
				button =2;
				gp.KeysI.downs = false;
			}
			else if(current == 2)
			{
				button = 3;
				gp.KeysI.downs = false;
			}
			else if(current == 3)
			{
				button = 1;
				gp.KeysI.downs = false;
			}
		}
		if(gp.KeysI.enter)
		{
			gp.playSE(4);
			if(button == 1)
			{
				gp.KeysI.gamestate = 1;
				gp.change = true;
				gp.KeysI.enter = false;
			}
			else if(button == 2)
			{
				gp.KeysI.gamestate = 3;
				gp.KeysI.enter = false;
			}
			else if(button == 3)
			{
				gp.KeysI.enter = false;
				System.exit(0);
			}
		}
	}
	public void draw(Graphics2D g2)
	{	
		if(gp.KeysI.gamestate == 3)
		{
			g2.drawImage(image1, 0, 0, 980, 720, null);
		}
		else if(gp.KeysI.gamestate == 0)
		{
		g2.setColor(Color.WHITE);
		g2.setFont(Retro1);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		g2.drawImage(player,9*48,2*48,96,96,null);
		g2.drawString("Mystery Maze", gp.screen_width/2 - 220, gp.screen_height/2 - 100);
		g2.setFont(Retro1);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
		if(button == 1)
		{
			g2.setColor(Color.BLUE);
			g2.drawString("-> START <-", 8*48, 7*48);
			g2.setColor(Color.WHITE);
			g2.drawString("-> INSTRUCTIONS <-", 320, 9*48);
			g2.drawString("-> QUIT <-", 8*48, 11*48);
		}
		if(button == 2)
		{
			g2.setColor(Color.WHITE);
			g2.drawString("-> START <-", 8*48, 7*48);
			g2.setColor(Color.BLUE);
			g2.drawString("-> INSTRUCTIONS <-", 320, 9*48);
			g2.setColor(Color.WHITE);
			g2.drawString("-> QUIT <-", 8*48, 11*48);
		}
		if(button == 3)
		{
			g2.setColor(Color.WHITE);
			g2.drawString("-> START <-", 8*48, 7*48);
			g2.drawString("-> INSTRUCTIONS <-", 320, 9*48);
			g2.setColor(Color.BLUE);
			g2.drawString("-> QUIT <-", 8*48, 11*48);
		}
		
		}
		
	}
}
