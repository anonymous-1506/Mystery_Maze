package main;

import javax.swing.JFrame;

public class Main {
public static void main(String[] args)
{	
	gamepanel gamepanel = new gamepanel();
	//window logic :
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setTitle("Mystery Maze");
	window.setResizable(false);
	window.add(gamepanel);
	
	window.pack();
	//	window.setSize(400, 200);
	window.setLocationRelativeTo(null);
	window.setVisible(true);
	gamepanel.start();
	
}
}
