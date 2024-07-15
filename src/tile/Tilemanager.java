package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.entity;
import main.gamepanel;

public class Tilemanager {
	gamepanel gp;
	public tile[] tiles;
	public Tilemanager(gamepanel gp){
		this.gp = gp;
		tiles = new tile[10];
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tiles[0] = new tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile1.png"));
			tiles[0].collision = false;
			
			tiles[1] = new tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile2.png"));
			tiles[1].collision = true;
			
			tiles[2] = new tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile3.png"));
			tiles[2].collision = true;
			
			tiles[3] = new tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			tiles[3].image2 = ImageIO.read(getClass().getResourceAsStream("/tiles/tile1.png"));
			tiles[3].collision = true;
			
			tiles[4] = new tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			tiles[4].image2 = ImageIO.read(getClass().getResourceAsStream("/objects/chest_open.png"));
			tiles[4].collision = false;
			
			tiles[5] = new tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/objects/obstacle.png"));
			tiles[5].collision = true;
			
			tiles[6] = new tile();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
			tiles[6].collision = false;
			
			tiles[7] = new tile();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile4_flash.png"));
			tiles[7].collision = true;
		}catch(IOException e)
		{
			e.getStackTrace();
		}
	}
	public void update(entity entity)
	{
		if(!tiles[3].collision && gp.keyobj.inStock)
		{	
			int i = gp.maze.doori();
			int j = gp.maze.doorj();
			if(Math.abs(gp.player.x - (j*48)) <= 20  && Math.abs(gp.player.y - (i*48)) <= 20)
			{
				tiles[3].num = 1;
				gp.gover.over_case = 2;
				gp.KeysI.gamestate = 4;
				gp.playSE(2);
				
			}
		}
		if(tiles[4].num == 0)
		{
			int a = gp.maze.chesti();
			int b = gp.maze.chestj();
			if(Math.abs(gp.player.x - (b*48)) <= 20 && Math.abs(gp.player.y - (48*a)) <= 20)
			{
				tiles[4].num = 1;
				gp.coin_score += 100;
				gp.playSE(3);
			}
		}
	}
	public void draw(Graphics2D g2,MazeGenerator maze) {
//		
		int x = 0;
		int y = 0;
//		
		for(int i = 0; i < maze.rows ;i++)
		{
			for(int j = 0; j < maze.cols; j++)
			{
				int arr = maze.getMaze(i, j);
				if(arr > 3)
				{
					if(arr == 4)
					{
						if(tiles[arr].num == 0)
						{
							g2.drawImage(tiles[0].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
							g2.drawImage(tiles[arr].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
						}
						else if (tiles[arr].num ==1)
						{
							g2.drawImage(tiles[0].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
							g2.drawImage(tiles[arr].image2, x,y,gp.tile_size_net,gp.tile_size_net,null);
						}
					}
					else if(arr != 4)
					{
						g2.drawImage(tiles[0].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
						g2.drawImage(tiles[arr].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
					}
				}
				else if(arr == 3)
				{
					if(tiles[arr].num == 0)
					{
						g2.drawImage(tiles[arr].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
					}
					else if(tiles[arr].num ==1)
					{
						g2.drawImage(tiles[arr].image2, x,y,gp.tile_size_net,gp.tile_size_net,null);
					}
				}
				else
				{
					g2.drawImage(tiles[arr].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
				}
				x += gp.tile_size_net;
			}
			y += 48;
			x = 0;
		}
//		int kx = 0;
//		for(int k = 0; k < gp.maze.cols; k++)
//		{
//			g2.drawImage(tiles[1].image,kx,0,gp.tile_size_net,gp.tile_size_net,null);
//			kx += gp.tile_size_net;
//		}
//		
	}
}
