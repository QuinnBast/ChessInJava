package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private MenuGui menuGui = new MenuGui();
	private BoardGui boardGui = new BoardGui();
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

	//Constructor to set up the window
	public userGui(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		
		this.window.add(boardGui.getBoardBackground(), BorderLayout.CENTER);		
		this.window.setVisible(true);
	}	
}
