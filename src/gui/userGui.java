package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private BoardGui boardGui;
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

	//Constructor to set up the window
	public userGui(ChessBoard theBoard){
		boardGui = new BoardGui(theBoard);
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
		for (int i=0; i<theTiles.size(); i++){
			//loop through the tiles
			for (int j=0; j<theBoard.getBoard().size(); j++){
				int boardx = theBoard.getBoard().get(j).getLocation().getX();
				int boardy = theBoard.getBoard().get(j).getLocation().getY();
				int tilex = theTiles.get(i).getGridXPos();
				int tiley = theTiles.get(i).getGridYPos();
						
				//if there is a piece at the tile location,
				if (tilex == boardx	&& tiley == boardy){
					//we need to set the tile to be linked to a piece.
					theTiles.get(i).setPiece(theBoard.getBoard().get(j)); //set the tile to have this piece
					break;
				} else {theTiles.get(i).setPiece(null);}
			}
			
			if (theTiles.get(i).getPiece() != null){
				//assign in an icon
				BufferedImage img = null;
				try{
					img = ImageIO.read(getClass().getResource(theTiles.get(i).getPiece().getImagePath()));
				}catch(IOException e){
					e.printStackTrace();
				}
				ImageIcon icon = new ImageIcon(img);
				JLabel label = new JLabel();
				label.setIcon(icon);
				theTiles.get(i).add(label);
				label.repaint();
				}
			}
			this.window.validate();
			this.window.repaint();
			}
	}
