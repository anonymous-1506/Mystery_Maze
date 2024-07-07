 package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
	public int x;
	public int y;
	public int speed;
	public BufferedImage up1,up2,up3,up4,down1,down2,down3,down4,right1,right2,right3,left1,left2,left3;
	public String direction;
	public int spritecount = 0;
	public int spritenum = 1;
	public Rectangle SolidArea = new Rectangle(0,0,48,48);;
	public boolean collision_on = false;
	
}
