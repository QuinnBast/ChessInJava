package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

import Engine.ChessBoard;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private final JLayeredPane windowLayers = new JLayeredPane();
	private takenPieceGui takenPieces = new takenPieceGui();
	private scoreBoardGui scoreGui = new scoreBoardGui();
	private PromotionPanel promotionPanel = new PromotionPanel();
	private BoardGui boardGui = new BoardGui(takenPieces,scoreGui,promotionPanel);
	private MenuGui menuGui = new MenuGui(boardGui);
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800,800);

	//Constructor to set up the window
	public userGui(){
		makeWindow();
	}
	
	private void makeWindow(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		this.window.setTitle("Chess");
		this.window.add(windowLayers);

		//add the chess board
		boardGui.getBoardBackground().setBounds(60,60,600,600);
		windowLayers.add(boardGui.getBoardBackground());
		//add a side panel
		takenPieces.getPanel().setBounds(0,0,60,600);
		windowLayers.add(takenPieces.getPanel());

		scoreGui.getPanel().setBounds(60,0,600,60);
		windowLayers.add(scoreGui.getPanel());

		windowLayers.add(promotionPanel, JLayeredPane.MODAL_LAYER);

		windowLayers.setVisible(true);

		//Set the window's Icon
		this.window.setIconImage(
			    new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
		this.window.setVisible(true);
		this.updateWindow();

		window.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateWindow();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});


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
