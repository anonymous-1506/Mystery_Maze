package objects;

import main.gamepanel;

public class bomb_placer {
	gamepanel gp;
	public bomb_placer(gamepanel gp)
	{
		this.gp = gp;
	}
	public void bomb_update()
	{
		if(gp.KeysI.space == 1)
		{
			if(gp.bomb_count < 3)
			{	
				gp.KeysI.space = 0;
				gp.bombs[gp.bomb_count] = new bomb_obj(gp);
				gp.player.y += gp.tile_size_net;
				gp.bomb_count++;
			}
		}
	}
}
