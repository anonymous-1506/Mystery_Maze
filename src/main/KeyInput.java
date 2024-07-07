package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	public boolean up,down,left,right;
	public int bomb = 0;
	
	
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
			bomb = 1;
			break;
		case KeyEvent.VK_DOWN:
			bomb = 2;
			break;
		case KeyEvent.VK_LEFT:
			bomb = 3;
			break;
		case KeyEvent.VK_RIGHT:
			bomb = 4;
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
