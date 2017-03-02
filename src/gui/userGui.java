package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Engine.ChessBoard;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private takenPieceGui takenPieces = new takenPieceGui();
	private scoreBoardGui scoreGui = new scoreBoardGui();
	private BoardGui boardGui = new BoardGui(takenPieces,scoreGui);
	private MenuGui menuGui = new MenuGui(boardGui);
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(700,700);

	//Constructor to set up the window
	public userGui(){
		makeWindow();
	}
	
	private void makeWindow(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		this.window.setTitle("Chess");
		//add the chess board
		this.window.add(boardGui.getBoardBackground(), BorderLayout.CENTER);
		//add a side panel
		this.window.add(takenPieces.getPanel(), BorderLayout.WEST);
		this.window.add(scoreGui.getPanel(), BorderLayout.NORTH);
		
		//Set the window's Icon
		this.window.setIconImage(
			    new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
		this.window.setVisible(true);
	}
	
	public JFrame getWindow(){
		return window;
	}
	
	public void updateWindow(){
		boardGui.getBoardBackground().updateBoard();
		takenPieces.getPanel().updateTakenPieces();
		scoreGui.getPanel().updateScore();
	}
}
