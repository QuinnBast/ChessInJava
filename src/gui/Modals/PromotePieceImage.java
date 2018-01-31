package gui.Modals;

import Engine.Board.ChessBoard;
import Engine.GameState;
import Engine.Board.Pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Quinn on 1/26/2018.
 */
public class PromotePieceImage extends JButton {

    private JLabel label = new JLabel();
    private JPanel callback;

    public PromotePieceImage(String pieceName, JPanel parent) {

        this.callback = parent;

        this.addMouseListener(new MouseListener() {
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      //Promote button was clicked.
                                      for(Piece p : ChessBoard.board){
                                          if((p.getLocation().getY() == 0 || p.getLocation().getY() == 7) && p.getColor() != GameState.currentMove && p instanceof Pawn) {
                                              String owner = GameState.currentMove == "White" ? "Black" : "White";
                                              Location l = p.getLocation();
                                              ChessBoard.board.remove(p);
                                              switch(pieceName.split(" ")[1]){
                                                  case "Knight":
                                                      ChessBoard.board.add(new Knight(owner, l.getX(), l.getY()));
                                                      break;
                                                  case "Rook":
                                                      ChessBoard.board.add(new Rook(owner, l.getX(), l.getY()));
                                                      break;
                                                  case "Bishop":
                                                      ChessBoard.board.add(new Bishop(owner, l.getX(), l.getY()));
                                                      break;
                                                  case "Queen":
                                                      ChessBoard.board.add(new Queen(owner, l.getX(), l.getY()));
                                                      break;
                                              }
                                              //Make the promotion box go away.
                                              ((PromotePieceImage)e.getSource()).updateParent();

                                              //Force a board update by clicking the mouse to render the graphics of the new piece
                                              try {
                                                  Robot bot = new Robot();
                                                  bot.mousePress(InputEvent.BUTTON1_MASK);
                                                  bot.mouseRelease(InputEvent.BUTTON1_MASK);
                                              } catch (AWTException e1) {
                                                  e1.printStackTrace();
                                              }

                                          }
                                      }
                                  }

                                  @Override
                                  public void mousePressed(MouseEvent e) {

                                  }

                                  @Override
                                  public void mouseReleased(MouseEvent e) {

                                  }

                                  @Override
                                  public void mouseEntered(MouseEvent e) {

                                  }

                                  @Override
                                  public void mouseExited(MouseEvent e) {

                                  }
                              });

                String type[] = pieceName.split(" ");

        //assign in an icon
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/Images/" + type[0] + type[1] + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        this.setPreferredSize(new Dimension(70, 70));
        this.label.setIcon(icon);
        this.setSize(50, 50);
        label.repaint();
        this.add(label);
        revalidate();
        repaint();
    }

    public void updateParent(){
        this.callback.setVisible(false);
        revalidate();
        repaint();
    }
}
