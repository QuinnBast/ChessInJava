package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;
import Pieces.Location;
import Pieces.Piece;

public class BoardGui {
	private final BoardPanel boardPanel;
	private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(50,50);
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
	
	public BoardGui(ChessBoard theBoard){
		//constructor for BoardGui
		boardPanel = new BoardPanel(theBoard);
	}
	
	public BoardPanel getPanel(){
		return this.boardPanel;
	}
	
	public class BoardPanel extends JPanel{
		private ArrayList<TilePanel> thePanels = new ArrayList<TilePanel>();
		
		//checks for clicking a piece
		private TilePanel firstPanel;
		private ChessBoard theBoard;
		
		BoardPanel(ChessBoard aBoard){
			//constructor for boardpanel
			super(new GridLayout(8,8));
			theBoard = aBoard;
			
			for(int i=0; i<8; i++){
				//Add a new tile panel for each square on the board.
				for(int j=0; j<8; j++){
					TilePanel newPanel = new TilePanel(j, 7-i);
					newPanel.addMouseListener(new MouseListener(){
						@Override
						public void mouseClicked(final MouseEvent e){
							TilePanel clickedPanel = (TilePanel) e.getComponent();
							if (firstPanel == null){
								if (clickedPanel.getPiece() != null){
									firstPanel = clickedPanel;
								} else {firstPanel = null;}
							} else{
								//We are chosing where to move the piece
								theBoard.move(firstPanel.getPiece(), new Location(clickedPanel.posx, clickedPanel.posy));
								firstPanel = null;
							}
							//need to update the window.
							System.out.println("clickedx: " + clickedPanel.posx + "clickedy: " + clickedPanel.posy);
							System.out.println("After move-if possible-Piece at location: " + theBoard.getPieceAtLocation(clickedPanel.posx, clickedPanel.posy));
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					
				});
					
					
					thePanels.add(newPanel);
					add(newPanel);
				}
			}
			setPreferredSize(BOARD_PANEL_DIMENSION);
			validate();
		}
		
		public ArrayList<TilePanel> getTiles(){
			return this.thePanels;
		}
		
	}
	
	public class TilePanel extends JPanel{
		private int posx;
		private int posy;
		private Piece pieceAtTile = null;
		
		public Piece getPiece(){
			return pieceAtTile;
		}
		
		public void setPiece(Piece piece){
			this.pieceAtTile = piece;
		}
		
		public int getGridXPos(){
			return this.posx;
		}
		
		public int getGridYPos(){
			return this.posy;
		}
		
		TilePanel(int i, int j){
			//constructor for the TilePanels
			super(new GridBagLayout());
			
			this.posx = i;
			this.posy = j;
			
			setPreferredSize(TILE_PANEL_DIMENSION);
			if (i % 2 == 0){
				if (j % 2 == 0){
					setBackground(Color.lightGray);
				}
				else{

					setBackground(Color.WHITE);
				}
			}
			else{
				if (j % 2 == 0){
					setBackground(Color.WHITE);
				}
				else{
					setBackground(Color.lightGray);
				}
			}
		}
	}
	
	public BoardPanel getBoardBackground(){
		return boardPanel;
	}

}
