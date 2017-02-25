package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;

public class BoardGui {
	private final BoardPanel boardPanel = new BoardPanel();
	private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(50,50);
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
	
	public BoardGui(){
		//constructor for BoardGui
	}
	
	public BoardPanel getPanel(){
		return this.boardPanel;
	}
	
	public class BoardPanel extends JPanel{
		private ArrayList<TilePanel> thePanels = new ArrayList<TilePanel>();
		
		BoardPanel(){
			//constructor for boardpanel
			super(new GridLayout(8,8));
			for(int i=0; i<8; i++){
				//Add a new tile panel for each square on the board.
				for(int j=0; j<8; j++){
					TilePanel newPanel = new TilePanel(j, 7-i);
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
