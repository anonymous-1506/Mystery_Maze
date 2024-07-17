package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class BaseUI {
	gamepanel gp;
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;
	BufferedImage image4;
	BufferedImage image5;
	BufferedImage health1;
	BufferedImage health2;
	BufferedImage health3;
	BufferedImage health4;
	BufferedImage health5;
	BufferedImage deadSkull;
	Font base = new Font("Arial",Font.PLAIN,20);
	Font base1 = new Font("Arial",Font.PLAIN,40);
	Font Retro1, Retro2,Indic;
	public BaseUI(gamepanel gp) {
		this.gp = gp;
		try
		{
			image1 = ImageIO.read(getClass().getResourceAsStream("/objects/bomb.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/title_art.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/objects/clock.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
			health1 = ImageIO.read(getClass().getResourceAsStream("/health_bar/0_final_0.png"));
			health2 = ImageIO.read(getClass().getResourceAsStream("/health_bar/25_final_4.png"));
			health3 = ImageIO.read(getClass().getResourceAsStream("/health_bar/50_final_8.png"));
			health4 = ImageIO.read(getClass().getResourceAsStream("/health_bar/75_final_12.png"));
			health5 = ImageIO.read(getClass().getResourceAsStream("/health_bar/100_final_16.png"));
			deadSkull = ImageIO.read(getClass().getResourceAsStream("/health_bar/DeadSkull.png"));//death
		}catch(IOException e)
		{
			e.getStackTrace();
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
	public void draw(Graphics2D g2)
	{
		int total1 = gp.maze.cols * gp.tile_size_net;
		int total2 = gp.maze.rows * gp.tile_size_net;
		g2.setFont(base);
		g2.setColor(Color.WHITE);
//		g2.drawImage(image2, total/2 - 98, 0, 195, 48, null);
		//BOMB STATUS DISPLAY
		g2.drawImage(image1, total1 - 120, 10, 24, 24, null);
		g2.drawString(""+gp.Player_timer, 10,60);
		//TIMER STATUS DISPLAY
		g2.drawImage(image4, 1, 0,48, 48, null);
		g2.drawString(" : "+(3 - gp.bomb_count), total1 - 90, 30);
		//COIN SCORE DISPLAY:
		g2.drawImage(image5, total1 - 230, 10, 24, 24, null);
		g2.drawString(" : "+(gp.coin_score), total1 - 200, 30);
		//KEY STATUS DISPLAY
		if(gp.keyobj.inStock)
		{
			g2.drawImage(image3, total1 - 150, 10, 24, 24, null);
		}
		//HEATH STAUS DISPLAY
		if (gp.health_status <= 100 && gp.health_status > 75)
		{
			g2.drawImage(health5, total2/2 + 50, -10, 3*gp.tile_size_net,3* gp.tile_size_net, null);
		}
		else if(gp.health_status <= 75 && gp.health_status > 50)
		{
			g2.drawImage(health4, total2/2 + 50, -10, 3*gp.tile_size_net,3* gp.tile_size_net, null);
		}
		else if(gp.health_status <= 50 && gp.health_status > 25)
		{
			g2.drawImage(health3, total2/2 + 50, -10, 3*gp.tile_size_net,3* gp.tile_size_net, null);
		}
		else if(gp.health_status <= 25 && gp.health_status > 0)
		{
			g2.drawImage(health2, total2/2 + 50, -10, 3*gp.tile_size_net,3* gp.tile_size_net, null);
		}
		else if(gp.health_status == 0)
		{
			g2.drawImage(health1, total2/2 + 50, -10, 3*gp.tile_size_net,3* gp.tile_size_net, null);
		}
		g2.drawString("Health:"+gp.health_status, total2/2 + 60, 75);
		
		//PAUSE FEATURE:
		if(gp.KeysI.gamestate == 2)
		{	
			g2.setFont(base1);
			g2.drawString("PAUSED", 48*(int)gp.maze.rows/2, 48*((int)gp.maze.cols/2 - 2));
			g2.setFont(base);
			g2.drawString("Press SpaceBar to resume", 48*(int)gp.maze.rows/2, 48*((int)gp.maze.cols/2 - 1));
		}
			
	}
}
