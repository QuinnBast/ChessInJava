package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
			whitePieces.setSize(new Dimension(37, 600));
			blackPieces.setSize(new Dimension(37, 600));
			whitePieces.setPreferredSize(new Dimension(37, 600));
			blackPieces.setPreferredSize(new Dimension(37, 600));
			whitePieces.setLayout(new BoxLayout(whitePieces, BoxLayout.Y_AXIS));
			blackPieces.setLayout(new BoxLayout(blackPieces, BoxLayout.Y_AXIS));
			
			for (int i=0; i<ChessBoard.takenPieces.size(); i++){
				if (ChessBoard.takenPieces.get(i).getColor() == "white"){
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					img = resize(img, 30, 30);
					ImageIcon icon = new ImageIcon(img);
					whitePieces.add(new JLabel(icon));
				} else {
					BufferedImage img = null;
					try{
						img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
					}catch(IOException e){
						e.printStackTrace();
					}
					img = resize(img, 30, 30);
					ImageIcon icon = new ImageIcon(img);
					blackPieces.add(new JLabel(icon));
				}
			}
			this.add(whitePieces);
			this.add(blackPieces);
		}
		
		public BufferedImage resize(BufferedImage image, int width, int height) {
		    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		    Graphics2D g2d = (Graphics2D) bi.createGraphics();
		    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		    g2d.drawImage(image, 0, 0, width, height, null);
		    g2d.dispose();
		    return bi;
		}
	}	
}
