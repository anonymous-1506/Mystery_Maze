package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
			tiles[3].collision = true;
			
			tiles[4] = new tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			tiles[4].collision = false;
			
			tiles[5] = new tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/objects/obstacle.png"));
			tiles[5].collision = false;
			
		}catch(IOException e)
		{
			e.getStackTrace();
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
				g2.drawImage(tiles[arr].image, x,y,gp.tile_size_net,gp.tile_size_net,null);
				x += gp.tile_size_net;
			}
			y += 48;
			x = 0;
		}
		
	}
}
