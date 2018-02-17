package gui.Board;

import Engine.Board.ChessBoard;
import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Pawn;
import gui.Modals.ModalController;
import gui.Window.WindowLayers;
import gui.userGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Quinn on 1/30/2018.
 */
public class ChessBoardPanel extends JPanel {

    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(50,50);
    private ArrayList<TilePanel> thePanels = new ArrayList<TilePanel>();

    //checks for clicking a piece
    private TilePanel firstPanel;
    private Color firstPanelColor;

    public ChessBoardPanel(){
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
            for (int j = 0; j< ChessBoard.board.size(); j++){
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
            userGui.modalController.displayPromotionPanel();
        }

        //gui.Window.Window.updateWindow();

        revalidate();
        repaint();
    }
}
