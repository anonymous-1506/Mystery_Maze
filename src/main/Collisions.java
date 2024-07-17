package main;

import javax.swing.text.html.parser.Entity;
import objects.key_object;
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
		int entityRectLeftX = entity.x + entity.SolidArea.x;
		int entityRectRightX = entity.x + entity.SolidArea.x + entity.SolidArea.width;
		int entityRectTopY = entity.y + entity.SolidArea.y;
		int entityRectBottomY = entity.y + entity.SolidArea.y + entity.SolidArea.height;
		//rows and columns in the grid corresponding to that sides
		int entityLeftCol = entityRectLeftX/gp.tile_size_net;
		int entityRightCol = entityRectRightX/gp.tile_size_net;
		int entityTopRow = entityRectTopY/gp.tile_size_net;
		int entityBottomRow = entityRectBottomY/gp.tile_size_net;
		
		boolean tile1,tile2;
		int tile1_2,tile2_2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityRectTopY - entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
				tile1 = gp.maze.getMazeBool(entityTopRow,entityLeftCol);
				tile1_2 = gp.maze.getMazeBoolType(entityTopRow,entityLeftCol);
				tile2 = gp.maze.getMazeBool(entityTopRow,entityRightCol);
				tile2_2 = gp.maze.getMazeBoolType(entityTopRow,entityRightCol);
				if (tile1 == true || tile2 == true)
				{	
					if(tile1_2 == 5 || tile2_2 == 5)
					{
						gp.health_status --;
					}
					entity.collision_on = true;
				}
			break;
		case "down":
			entityBottomRow = (entityRectBottomY + entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityLeftCol);
			tile1_2 = gp.maze.getMazeBoolType(entityBottomRow,entityLeftCol);
			tile2 = gp.maze.getMazeBool(entityBottomRow,entityRightCol);
			tile2_2 = gp.maze.getMazeBoolType(entityBottomRow,entityRightCol);
			if (tile1 == true || tile2 == true)
			{	
				if(tile1_2 == 5 || tile2_2 == 5)
				{
					gp.health_status --;
				}
				entity.collision_on = true;
			}
			break;
		case "left":
			entityLeftCol = (entityRectLeftX - entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityLeftCol);
			tile1_2 = gp.maze.getMazeBoolType(entityBottomRow,entityLeftCol);
			tile2 = gp.maze.getMazeBool(entityTopRow,entityLeftCol);
			tile2_2 = gp.maze.getMazeBoolType(entityTopRow,entityLeftCol);
			if (tile1 == true || tile2 == true)
			{	
				if(tile1_2 == 5 || tile2_2 == 5)
				{
					gp.health_status --;
				}
				entity.collision_on = true;
			}
			break;
		case "right":
			entityRightCol = (entityRectRightX + entity.speed)/gp.tile_size_net; //block that the entity is trying to enter
			tile1 = gp.maze.getMazeBool(entityBottomRow,entityRightCol);
			tile1_2 = gp.maze.getMazeBoolType(entityBottomRow,entityRightCol);
			tile2 = gp.maze.getMazeBool(entityTopRow,entityRightCol);
			tile2_2 = gp.maze.getMazeBoolType(entityTopRow,entityRightCol);
			if (tile1 == true || tile2 == true)
			{	
				if(tile1_2 == 5 || tile2_2 == 5)
				{
					gp.health_status --;
				}
				entity.collision_on = true;
			}
			break;
		}
	}
	
}
