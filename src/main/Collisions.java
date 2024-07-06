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
		
		boolean tile1,tile2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityRectTopY - entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
				tile1 = gp.maze.getMazeBool(entityTopRow,entityLeftCol);
				tile2 = gp.maze.getMazeBool(entityTopRow,entityRightCol);
				if (tile1 == true || tile2 == true)
				{
					entity.collision_on = true;
				}
			break;
		case "down":
			entityBottomRow = (entityRectBottomY + entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityLeftCol);
			tile2 = gp.maze.getMazeBool(entityBottomRow,entityRightCol);
			if (tile1 == true || tile2 == true)
			{
				entity.collision_on = true;
			}
			break;
		case "left":
			entityLeftCol = (entityRectLeftX - entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityLeftCol);
			tile2 = gp.maze.getMazeBool(entityTopRow,entityLeftCol);
			if (tile1 == true || tile2 == true)
			{
				entity.collision_on = true;
			}
			break;
		case "right":
			entityRightCol = (entityRectRightX + entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityRightCol);
			tile2 = gp.maze.getMazeBool(entityTopRow,entityRightCol);
			if (tile1 == true || tile2 == true)
			{
				entity.collision_on = true;
			}
			break;
		}
				
		
	}
}
