package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Engine.ChessBoard;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private MenuGui menuGui = new MenuGui();
	private BoardGui boardGui;
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

	//Constructor to set up the window
	public userGui(){
		boardGui = new BoardGui();
		makeWindow();
	}
	
	private void makeWindow(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		this.window.setTitle("Chess");
		this.window.add(boardGui.getBoardBackground(), BorderLayout.CENTER);
		//Set the window's Icon
		this.window.setIconImage(
			    new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
		this.window.setVisible(true);
	}
	
	private BoardGui getBoard(){
		return this.boardGui;
	}
}
