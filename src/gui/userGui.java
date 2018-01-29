package gui;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private final JLayeredPane windowLayers = new JLayeredPane();

	private final takenPieceGui takenPieces = new takenPieceGui();
	private final ScoreboardGui scoreGui = new ScoreboardGui();
	private final PromotionPanel promotionPanel = new PromotionPanel();
	private final BoardGui boardGui = new BoardGui(promotionPanel,this);
	private final MenuGui menuGui = new MenuGui(boardGui);
	private final MoveHistoryGui historyGui = new MoveHistoryGui();
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800,800);

	//Constructor to set up the window
	public userGui(){
		makeWindow();
	}
	
	private void makeWindow() {
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		this.window.setTitle("Chess");
		this.window.add(windowLayers);

		//add the chess board
		boardGui.getBoardBackground().setBounds(120, 60, 600, 600);
		windowLayers.add(boardGui.getBoardBackground());
		//add a side panel
		takenPieces.getPanel().setBounds(0, 0, 120, 600);
		windowLayers.add(takenPieces.getPanel());

		scoreGui.getPanel().setBounds(120, 0, 600, 60);
		windowLayers.add(scoreGui.getPanel());

		historyGui.setBounds(120, 660, 600, 60);
		windowLayers.add(historyGui);

		windowLayers.add(promotionPanel, JLayeredPane.MODAL_LAYER);

		windowLayers.setVisible(true);

		//Set the window's Icon
		this.window.setIconImage(
				new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
		this.window.setVisible(true);
		this.updateWindow();
	}
	
	public JFrame getWindow(){
		return window;
	}
	
	public void updateWindow(){
		takenPieces.getPanel().updateTakenPieces();
		scoreGui.getPanel().updateScore();
		historyGui.updateMoves();
	}
}
