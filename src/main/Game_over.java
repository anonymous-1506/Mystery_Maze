package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Game_over {
	gamepanel gp;
	public int over_case = 0;
	int button = 1;
	Font Retro1,Retro2,Indic;
	BufferedImage case1_1,case1_2,case1_3,case1_4,case2_1,case2_2,case2_3, case3_1,case3_2,case3_3;
	public int animation = 1;
	public int animation2 = 1;
	
	public Game_over(gamepanel gp)
	{
		this.gp = gp;
		animation = 1;
		animation2 = 1;
		//IMAGES:
		try
		{
			case1_1 = ImageIO.read(getClass().getResourceAsStream("/gameover/time1.png"));//timeup
			case1_2 = ImageIO.read(getClass().getResourceAsStream("/gameover/time2.png"));//timeup
			case1_3 = ImageIO.read(getClass().getResourceAsStream("/gameover/time3.png"));//timeup
			case1_4 = ImageIO.read(getClass().getResourceAsStream("/gameover/time4.png"));//timeup
			case2_1 = ImageIO.read(getClass().getResourceAsStream("/gameover/trophyw.png"));//victory
			case2_2 = ImageIO.read(getClass().getResourceAsStream("/gameover/trophym.png"));//victory
			case2_3 = ImageIO.read(getClass().getResourceAsStream("/gameover/trophyg.png"));//victory
			case3_1 = ImageIO.read(getClass().getResourceAsStream("/gameover/skullw.png"));//deathskull
			case3_2 = ImageIO.read(getClass().getResourceAsStream("/gameover/skullr.png"));//deathskull
			case3_3 = ImageIO.read(getClass().getResourceAsStream("/gameover/skullb.png"));//deathskull
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
				switch(animation2)
				{
				case 1:
					g2.drawImage(case1_1,gp.screen_width/2 - 100,gp.screen_height - 300,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				case 2:
					g2.drawImage(case1_2,gp.screen_width/2 - 100,gp.screen_height - 300,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				case 3:
					g2.drawImage(case1_3,gp.screen_width/2 - 100,gp.screen_height - 300,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				case 4:
					g2.drawImage(case1_4,gp.screen_width/2 - 100,gp.screen_height - 300,gp.tile_size_net*5,gp.tile_size_net*5,null);
				}
				g2.drawString("GAME OVER! TIME'S UP", gp.screen_width/2 - 400, gp.screen_height/2 - 100);
				break;
			case 2:
				switch(animation)
				{
				case 1:
					g2.drawImage(case2_1,gp.screen_height/2 - 50,gp.screen_height - 400,gp.tile_size_net*8,gp.tile_size_net*8,null);
					break;
				case 2:
					g2.drawImage(case2_2,gp.screen_height/2 - 50,gp.screen_height - 400,gp.tile_size_net*8,gp.tile_size_net*8,null);
					break;
				case 3:
					g2.drawImage(case2_3,gp.screen_height/2 - 50,gp.screen_height - 400,gp.tile_size_net*8,gp.tile_size_net*8,null);
					break;
				}
				g2.drawString("CONGRATULATIONS !", gp.screen_width/2 - 300, gp.screen_height/2 - 200);
				g2.drawString("VICTORY", gp.screen_width/2 - 120, gp.screen_height/2 - 100);
				break;
			case 3:
				switch(animation)
				{
				case 1:
					g2.drawImage(case3_1,gp.screen_height/2,0,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				case 2:
					g2.drawImage(case3_2,gp.screen_height/2,0,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				case 3:
					g2.drawImage(case3_3,gp.screen_height/2,0,gp.tile_size_net*5,gp.tile_size_net*5,null);
					break;
				}
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
