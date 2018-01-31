package gui.Window;

import Engine.Movement.MovementControls.MoveHistory;
import gui.Board.ChessBoardPanel;
import gui.Modals.PromotionPanel;
import gui.MoveHistory.MoveHistoryPanel;
import gui.Scoreboard.ScorePanel;
import gui.TakenPieces.TakenPiecePanel;

import javax.swing.*;

/**
 * Created by Quinn on 1/30/2018.
 */
public class WindowLayers extends JLayeredPane {

    public static TakenPiecePanel takenPiecePanel = new TakenPiecePanel();
    public static MoveHistoryPanel moveHistoryPanel = new MoveHistoryPanel();
    public static ScorePanel scorePanel = new ScorePanel();
    public static ChessBoardPanel boardGui;

    public WindowLayers() {

        //add taken piece panel
        takenPiecePanel.setBounds(0, 0, 120, 600);
        this.add(takenPiecePanel);

        scorePanel.setBounds(120, 0, 600, 60);
        this.add(scorePanel);

        moveHistoryPanel.setBounds(120, 660, 600, 60);
        this.add(moveHistoryPanel);

        boardGui = new ChessBoardPanel();
        //add the chess board
        boardGui.setBounds(120, 60, 600, 600);
        this.add(boardGui);

        this.setVisible(true);
    }

    public void updateLayers(){
        this.takenPiecePanel.updateTakenPieces();
        this.scorePanel.updateScore();
        this.moveHistoryPanel.updateMoves();
    }

}
