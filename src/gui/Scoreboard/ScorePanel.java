package gui.Scoreboard;

import Engine.Board.ChessBoard;
import Engine.GameStates.Gamestates;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/30/2018.
 */
public class ScorePanel extends JPanel {


    private JPanel whiteScore = new JPanel();
    private JPanel blackScore = new JPanel();
    private JPanel inCheck = new JPanel();

    //labels for each panel
    private JLabel WhitePanel = new JLabel();
    private JLabel BlackPanel = new JLabel();
    private JLabel inCheckText = new JLabel("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>In Check!</p></html>");

    public ScorePanel(){
        initializeThis();
        updateScore();
        this.add(inCheck);	//For some reason I have to add this first for it to be on the left.
        this.add(whiteScore);
        this.add(blackScore);
        this.validate();
        this.repaint();
    }


    public void updateScore(){
        WhitePanel.setText("<html><p>White</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getWhiteWins() + "</p></html>");
        BlackPanel.setText("<html><p>Black</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getBlackWins() + "</p></html>");
        if (ChessBoard.theState.getGameState() != Gamestates.INGAME){
            inCheckText.setText("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>"+ChessBoard.theState.getGameState().toString()+"</p></html>");
            inCheck.setVisible(true);
        } else {
            inCheckText.setText("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>In Check!</p></html>");
        }
        if (ChessBoard.theState.getPlayerInCheck(ChessBoard.theState.getCurrentPlayer())){
            inCheck.setVisible(true);
        } else {
            inCheck.setVisible(false);
        }
    }

    private void initializeThis(){
        this.setSize(new Dimension(600, 75));
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridBagLayout());
        whiteScore.setBackground(Color.LIGHT_GRAY);
        blackScore.setBackground(Color.LIGHT_GRAY);
        inCheck.setBackground(Color.LIGHT_GRAY);
        this.whiteScore.add(WhitePanel);
        this.blackScore.add(BlackPanel);
        inCheck.add(inCheckText);
    }

    public JPanel getWhiteScorePanel(){
        return this.whiteScore;
    }

    public JPanel getBlackScorePanel(){
        return this.blackScore;
    }

}
