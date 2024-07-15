package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Game_over {
	gamepanel gp;
	public int over_case = 0;
	int button = 1;
	Font Retro1,Retro2,Indic;
	BufferedImage case1, case2, case3;
	public Game_over(gamepanel gp)
	{
		this.gp = gp;
		//IMAGES:
		try
		{
			case1 = ImageIO.read(getClass().getResourceAsStream("/gameplay/case1.png"));//timeup
			case2 = ImageIO.read(getClass().getResourceAsStream("/gameplay/case2.png"));//victory
			case3 = ImageIO.read(getClass().getResourceAsStream("/gameplay/case3.png"));//death
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		//FONTS:
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
		if(current == 2 && gp.KeysI.ups)
		{
			gp.playSE(4);
			button = 1;
			gp.KeysI.ups = false;
		}
		if(current == 1 && gp.KeysI.downs)
		{
			gp.playSE(4);
			button =2 ;
			gp.KeysI.downs = false;
		}
		if(gp.KeysI.enter)
		{
			gp.playSE(4);
			if(button == 1)
			{
				gp.KeysI.gamestate = 0;
				gp.KeysI.enter = false;
			}
			else if(button == 2)
			{
				
				gp.KeysI.enter = false;
				System.exit(0);
			}
		}
	}
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.WHITE);
		g2.setFont(Retro1);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,70F));
		switch(over_case)
		{
		case 1:
			g2.drawImage(case1,9*48,2*48,172,96,null);
			g2.drawString("GAME OVER! TIME'S UP", gp.screen_width/2 - 400, gp.screen_height/2 - 100);
			break;
		case 2:
			g2.drawImage(case2,9*48,0,172,96,null);
			g2.drawString("CONGRATULATIONS !", gp.screen_width/2 - 300, gp.screen_height/2 - 200);
			g2.drawString("VICTORY", gp.screen_width/2 - 120, gp.screen_height/2 - 100);
			break;
		case 3:
			g2.drawImage(case3,9*48,2*48,172,96,null);
			g2.drawString("GAME OVER! DEATH", gp.screen_width/2 - 300, gp.screen_height/2 - 100);
		}
		g2.setFont(Retro1);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
		if(button == 1)
		{
			g2.setColor(Color.BLUE);
			g2.drawString("-> MENU <-", 8*48, 7*48);
			g2.setColor(Color.WHITE);
			g2.drawString("-> QUIT <-", 8*48, 8*48);
		}
		if(button == 2)
		{
			g2.setColor(Color.WHITE);
			g2.drawString("-> MENU <-", 8*48, 7*48);
			g2.setColor(Color.BLUE);
			g2.drawString("-> QUIT <-", 8*48, 8*48);
		}
	}
}
