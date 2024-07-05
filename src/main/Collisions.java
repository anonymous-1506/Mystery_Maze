package main;

import entity.entity;

public class Collisions {
	gamepanel gp;
	public Collisions(gamepanel gp)
	{
		this.gp = gp;
	}
	public void check(entity entity)
	{	
		//the coordinates of the 4 sides of invisible rectangle
		int entityRectLeftX = entity.x + entity.solid_area.x;
		int entityRectRightX = entity.x + entity.solid_area.x + entity.solid_area.width;
		int entityRectTopY = entity.y + entity.solid_area.y;
		int entityRectBottomY = entity.y + entity.solid_area.y + entity.solid_area.height;
		//rows and columns in the grid corresponding to that sides
		int entityLeftCol = entityRectLeftX/gp.tile_size_net;
		int entityRightCol = entityRectRightX/gp.tile_size_net;
		int entityTopRow = entityRectTopY/gp.tile_size_net;
		int entityBottomRow = entityRectBottomY/gp.tile_size_net;
		
		int tile1,tile2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityRectTopY - entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
//			if(entityLeftCol <= 16 && entityRightCol <= 16 && entityTopRow <= 12)
			
				tile1 = gp.maze.getMaze(entityLeftCol,entityTopRow);
				tile2 = gp.maze.getMaze(entityRightCol, entityTopRow);
				if (gp.tilem.tiles[tile1].collision == true || gp.tilem.tiles[tile2].collision == true)
				{
					entity.collision_on = true;
				
			}
			break;
		case "down":
			break;
		case "left":
			break;
		case "right":
			break;
		}
				
		
	}
}
