package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;

public class takenPieceGui{
	private final takenPiecePanel takenPanel = new takenPiecePanel();
	
	takenPieceGui(){
		
	}
	
	public takenPiecePanel getPanel(){
		return this.takenPanel;
	}
	
	public class takenPiecePanel extends JPanel{
		private JPanel whitePieces = new JPanel();
		private JPanel blackPieces = new JPanel();
		
		
		takenPiecePanel(){
			this.setSize(new Dimension(75, 600));
			this.setVisible(true);
			this.setBackground(Color.CYAN);
			updateTakenPieces();
			this.add(whitePieces);
			this.add(blackPieces);
			this.validate();
			this.repaint();
		}
		
		public void updateTakenPieces(){
			this.removeAll();
			whitePieces = new JPanel();
			blackPieces = new JPanel();
			whitePieces.setLayout(new BoxLayout(whitePieces, BoxLayout.Y_AXIS));
			blackPieces.setLayout(new BoxLayout(blackPieces, BoxLayout.Y_AXIS));
			
			whitePieces.setSize(new Dimension(50, 500));
			blackPieces.setSize(new Dimension(50, 500));
			
			for (int i=0; i<ChessBoard.takenPieces.size(); i++){
				if (ChessBoard.takenPieces.get(i).getColor() == "white"){
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					ImageIcon icon = new ImageIcon(img);
					whitePieces.add(new JLabel(icon));
				} else {
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					ImageIcon icon = new ImageIcon(img);
					blackPieces.add(new JLabel(icon));
				}
			}
			this.add(whitePieces);
			this.add(blackPieces);
		}		
	}
	
}
