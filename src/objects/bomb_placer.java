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
		int c = gp.KeysI.bomb;
//		System.out.println("bomb "+c);
		if(c !=  0)
		{
			
		if(gp.bomb_count < gp.bomb_stock)
		{	
				switch(c) {
				case 1:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"up");
					gp.KeysI.bomb = 0;
					break;
				case 2:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"down");
					gp.KeysI.bomb = 0;
					break;
				case 3:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"left");
					gp.KeysI.bomb = 0;
					break;
				case 4:
					gp.bombs[gp.bomb_count] = new bomb_obj(gp,"right");
					gp.KeysI.bomb = 0;
					break;
						}
				gp.bomb_count++;
		}
		}
//			System.out.println("no:of bombs: "+gp.bomb_count);
	}
}