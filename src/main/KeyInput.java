package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	public boolean up,down,left,right;
	public int bomb = 0;
	public int gamestate = 0;
	public boolean ups,downs,enter;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub)
		int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_UP:
			if(gamestate == 1)
			{
				bomb = 1;
			}
			else if(gamestate == 0 || gamestate == 4)
			{
				ups = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(gamestate == 1)
			{
				bomb = 2;
			}
			else if(gamestate == 0 || gamestate == 4)
			{
				downs = true;
			}
			break;
		case KeyEvent.VK_LEFT:
			bomb = 3;
			break;
		case KeyEvent.VK_RIGHT:
			bomb = 4;
			break;
		case KeyEvent.VK_ESCAPE:
			gamestate = 0;
			break;
		case KeyEvent.VK_ENTER:
			if(gamestate == 0 || gamestate == 4)
			{
				enter = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			if(gamestate == 1)
				{
				gamestate = 2;
				}
			else if(gamestate == 2)
				{
				gamestate = 1;
				};
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
        int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_UP:
			bomb = 0;
			break;
		case KeyEvent.VK_DOWN:
			bomb = 0;
			break;
		case KeyEvent.VK_LEFT:
			bomb = 0;
			break;
		case KeyEvent.VK_RIGHT:
			bomb = 0;
			break;
		}
	}

}
