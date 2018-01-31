package gui.Board;

import Engine.Board.Pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Quinn on 1/30/2018.
 */
public class TilePanel extends JPanel {

    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
    public int posx;
    public int posy;
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
