package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyInput;
import main.gamepanel;
import objects.bomb_obj;

public class player extends entity{
	gamepanel gp;
	KeyInput keyH;
	public player(gamepanel gp, KeyInput keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
//		solid_area = new Rectangle();
		SolidArea.x = 8;
		SolidArea.y = 12;
		SolidArea.width = 32;
		SolidArea.height = 32;
		
		
		GetPlayerImage();
		SetDefault();
	}
	
	public void SetDefault() {
		int initial = gp.maze.getInitial();
		x = initial * gp.tile_size_net;
		y = 48*(gp.maze.rows - 1);
		speed = 2;
		direction = "down";
	}
	public void update() {
		
		
		
		if (keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true)
		{
			if(keyH.up == true)
			{   
				direction = "up";
//				this.y = Math.max(this.y - this.speed , 0);	
			}
			if(keyH.down == true)
			{
				direction = "down";
//				this.y = Math.min(this.y + this.speed,gp.screen_height - gp.tile_size_net);	
			}
			if(keyH.left == true)
			{
				direction = "left";
//				this.x = Math.max(this.x - this.speed,0);
			}
			if(keyH.right == true)
			{
				direction = "right";
//				this.x = Math.min(this.x + this.speed,gp.screen_width - gp.tile_size_net);
			}
			
			//CHECKING COLLISION:
			collision_on = false;
			gp.collision.check(this);
			//IF COLLISION IS FALSE, MOVE THEN ONLY:
			if(collision_on == false)
			{
				switch(direction) {
				case "up":this.y = Math.max(this.y - this.speed , 0);	
					break;
				case "down":this.y = Math.min(this.y + this.speed,gp.screen_height - gp.tile_size_net);
					break;
				case "left":this.x = Math.max(this.x - this.speed,0);
					break;
				case "right":this.x = Math.min(this.x + this.speed,gp.screen_width - gp.tile_size_net);
					break;
				}
			}
			
			spritecount++;
			if(spritecount > 10)
			{
				if(direction == "up" || direction == "down")
				{
					switch(spritenum) {
					case 1:
						spritenum = 2;
						break;
					case 2:
						spritenum = 3;
						break;
					case 3:
						spritenum = 4;
						break;
					case 4:
						spritenum = 1;
						break;
					}
					spritecount = 0;
				}
				if(direction == "left" || direction == "right")
				{
					switch(spritenum) {
					case 1:
						spritenum = 2;
						break;
					case 2:
						spritenum = 3;
						break;
					case 3:
						spritenum = 1;
						break;
					}
					spritecount = 0;
				}
			}
		}
		else {
			direction = "down";
			spritenum = 2;
		}
		
		
	}
	
	public void GetPlayerImage()
	{
		try
		{
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player/up4.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/down3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player/down4.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
						
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics2D g2) {

//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tile_size_net,gp.tile_size_net);
		BufferedImage image = null;
		
		switch (direction) {
		case"up":
			switch(spritenum) {
			case 1:
				image = up1;
				break;
			case 2:
				image = up2;
				break;
			case 3:
				image = up3;
				break;
			case 4:
				image = up4;
				break;
				}
			break;
		case"down":
			switch(spritenum) {
			case 1:
				image = down1;
				break;
			case 2:
				image = down2;
				break;
			case 3:
				image = down3;
				break;
			case 4:
				image = down4;
				break;
				}
			break;
		case"right":
			switch(spritenum) {
			case 1:
				image = right1;
				break;
			case 2:
				image = right2;
				break;
			case 3:
				image = right3;
				break;
				}
			break;
		case"left":
			switch(spritenum) {
			case 1:
				image = left1;
				break;
			case 2:
				image = left2;
				break;
			case 3:
				image = left3;
				break;
				}
			break;
			
		}
		
		g2.drawImage(image, x, y, gp.tile_size_net, gp.tile_size_net, null);
	}
}
