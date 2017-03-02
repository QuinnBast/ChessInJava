package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			JPanel tempWhite = new JPanel();
			JPanel tempBlack = new JPanel();
			for (int i=0; i<ChessBoard.takenPieces.size(); i++){
				if (ChessBoard.takenPieces.get(i).getColor() == "white"){
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					ImageIcon icon = new ImageIcon(img);
					tempWhite.add(new JLabel(icon));
					whitePieces.revalidate();
					whitePieces.repaint();
				} else {
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					ImageIcon icon = new ImageIcon(img);
					tempBlack.add(new JLabel(icon));
					blackPieces.revalidate();
					blackPieces.repaint();
				}
			}
			whitePieces = tempWhite;
			blackPieces = tempBlack;
			whitePieces.repaint();
			blackPieces.repaint();
		}		
	}
	
}
