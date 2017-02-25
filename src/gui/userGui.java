package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;
import gui.BoardGui.TilePanel;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private MenuGui menuGui = new MenuGui();
	private BoardGui boardGui = new BoardGui();
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

	//Constructor to set up the window
	public userGui(){
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
	
	public void updateBoard(ChessBoard theBoard){
		ArrayList<TilePanel> theTiles = this.getBoard().getPanel().getTiles();
		TilePanel giveIcon = null;
		for(int i=0; i<theBoard.getBoard().size(); i++){
			//For each piece on the board, set its image icon to that tile.
			for(int j=0; j<theTiles.size(); j++){
				int boardx = theBoard.getBoard().get(i).getLocation().getX();
				int boardy = theBoard.getBoard().get(i).getLocation().getY();
				int tilex = theTiles.get(j).getGridXPos();
				int tiley = theTiles.get(j).getGridYPos();
						
				if (tilex == boardx	&& tiley == boardy){
					giveIcon = theTiles.get(j);
					break;
				}
			}
			//Column major order
			BufferedImage img = null;
			try{
				img = ImageIO.read(getClass().getResource(theBoard.getBoard().get(i).getImagePath()));
			}catch(IOException e){
				e.printStackTrace();
			}
			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel();
			label.setIcon(icon);
			giveIcon.add(label);
			label.repaint();
			}
		this.window.validate();
		this.window.repaint();
	}
}
