package gui.TakenPieces;

import Engine.Board.ChessBoard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Quinn on 1/30/2018.
 */
public class TakenPiecePanel extends JPanel {


    private JPanel WhitePieces = new JPanel();
    private JPanel BlackPieces = new JPanel();


    public TakenPiecePanel(){
        this.setSize(new Dimension(75, 600));
        this.setVisible(true);

        updateTakenPieces();
        this.add(WhitePieces);
        this.add(BlackPieces);
        this.validate();
        this.repaint();
    }

    public void updateTakenPieces(){
        this.removeAll();
        WhitePieces = new JPanel();
        BlackPieces = new JPanel();
        WhitePieces.setSize(new Dimension(37, 600));
        BlackPieces.setSize(new Dimension(37, 600));
        WhitePieces.setPreferredSize(new Dimension(37, 600));
        BlackPieces.setPreferredSize(new Dimension(37, 600));
        WhitePieces.setLayout(new BoxLayout(WhitePieces, BoxLayout.Y_AXIS));
        BlackPieces.setLayout(new BoxLayout(BlackPieces, BoxLayout.Y_AXIS));

        for (int i = 0; i< ChessBoard.takenPieces.size(); i++){
            if (ChessBoard.takenPieces.get(i).getColor() == "White"){
                BufferedImage img = null;
                try{
                    img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
                }catch(IOException e){
                    e.printStackTrace();
                }
                img = resize(img, 30, 30);
                ImageIcon icon = new ImageIcon(img);
                WhitePieces.add(new JLabel(icon));
            } else {
                BufferedImage img = null;
                try{
                    img = ImageIO.read(getClass().getResource(ChessBoard.takenPieces.get(i).getImagePath()));
                }catch(IOException e){
                    e.printStackTrace();
                }
                img = resize(img, 30, 30);
                ImageIcon icon = new ImageIcon(img);
                BlackPieces.add(new JLabel(icon));
            }
        }
        this.add(WhitePieces);
        this.add(BlackPieces);
    }

    public BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public JPanel getTakenWhitePiecesPanel(){
        return this.WhitePieces;
    }

    public JPanel getTakenBlackPiecesPanel(){
        return this.BlackPieces;
    }

}
