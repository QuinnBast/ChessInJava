package gui;

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
import Pieces.Pawn;
import Pieces.Piece;

public class BoardGui {
	private final BoardPanel boardPanel;
	private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(50,50);
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
	private PromotionPanel promotionPanel;
	private userGui userGuiPointer;
	
	BoardGui(PromotionPanel promotePanelPtr, userGui userGuiPtr){
		//constructor for BoardGui
		this.promotionPanel = promotePanelPtr;
		boardPanel = new BoardPanel();
		boardPanel.validate();
		boardPanel.repaint();
		this.userGuiPointer = userGuiPtr;
	}
	
	public BoardPanel getPanel(){
		return this.boardPanel;
	}
	
	public class BoardPanel extends JPanel{

		private ArrayList<TilePanel> thePanels = new ArrayList<TilePanel>();
		
		//checks for clicking a piece
		private TilePanel firstPanel;
		private Color firstPanelColor;
		
		BoardPanel(){
			//constructor for boardpanel
			super(new GridLayout(8,8));
			
			for(int i=0; i<8; i++){
				//Add a new tile panel for each square on the board.
				for(int j=0; j<8; j++){
					TilePanel newPanel = new TilePanel(j, 7-i);
					newPanel.addMouseListener(new MouseListener(){
						@Override
						public void mouseClicked(final MouseEvent e){
							TilePanel clickedPanel = (TilePanel) e.getComponent();
							//if this is the first square that you have clicked,
							if (firstPanel == null){
								if (clickedPanel.getPiece() != null){
									firstPanel = clickedPanel;
									firstPanelColor = clickedPanel.getBackground();
									firstPanel.setBackground(Color.ORANGE);
								} else {firstPanel = null;}
							} else{
								//We are choosing where to move the piece
								firstPanel.getPiece().move(new Location(clickedPanel.posx, clickedPanel.posy));
								firstPanel.setBackground(firstPanelColor);
								firstPanel = null;
							}
							updateBoard();
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
			updateBoard();
		}
		
		public ArrayList<TilePanel> getTiles(){
			return this.thePanels;
		}
		
		public void updateBoard(){
						ArrayList<TilePanel> theTiles = getTiles();
			boolean isPromotion = false;
			int promotex = 0;
			int promotey = 0;
			for (int i=0; i<theTiles.size(); i++){
				//loop through the tiles
				for (int j=0; j<ChessBoard.board.size(); j++){
					int boardx = ChessBoard.board.get(j).getLocation().getX();
					int boardy = ChessBoard.board.get(j).getLocation().getY();
					int tilex = theTiles.get(i).getGridXPos();
					int tiley = theTiles.get(i).getGridYPos();
							
					//if there is a piece at the tile location,
					if (tilex == boardx	&& tiley == boardy){
						//we need to set the tile to be linked to a piece.
						theTiles.get(i).setPiece(ChessBoard.board.get(j)); //set the tile to have this piece
						//Check if the piece is a pawn being promoted.
						if(ChessBoard.board.get(j) instanceof Pawn && (ChessBoard.board.get(j).getLocation().getY() == 0 || ChessBoard.board.get(j).getLocation().getY() == 7)){
							isPromotion = true;
							promotex = ChessBoard.board.get(j).getLocation().getX();
							promotey = ChessBoard.board.get(j).getLocation().getY();
						}

						break;
					} else {theTiles.get(i).setPiece(null);}
				}	
				theTiles.get(i).setImage();
			}

			//Check if there is a pawn promotion happening
			if(isPromotion){
				//Create interface to select what piece the user wants to make.
				promotionPanel.setVisible(true);
				promotionPanel.setLocation(300 - 75, 300 - 75);
			} else {
				promotionPanel.setVisible(false);
			}

			if(userGuiPointer != null){
				userGuiPointer.updateWindow();
			}

			revalidate();
			repaint();
		}
	}
	
	public class TilePanel extends JPanel{
		private int posx;
		private int posy;
		private Piece pieceAtTile = null;
		private JLabel theLabel = new JLabel();
		
		public Piece getPiece(){
			return pieceAtTile;
		}
		
		public void setImage(){
			//assign in an icon
			if (this.pieceAtTile != null){
				BufferedImage img = null;
				try{
					img = ImageIO.read(getClass().getResource(this.pieceAtTile.getImagePath()));
				}catch(IOException e){
					e.printStackTrace();
				}
				ImageIcon icon = new ImageIcon(img);
				this.theLabel.setIcon(icon);
				theLabel.repaint();
			}
			else{this.theLabel.setIcon(null);}
			revalidate();
			repaint();
		}
		
		public void setPiece(Piece piece){
			this.pieceAtTile = piece;
			setImage();
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
			this.add(theLabel);
			
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
