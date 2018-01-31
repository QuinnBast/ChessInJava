package gui.MoveHistory;

import Engine.GameState;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/28/2018.
 */
public class MoveHistoryPanel extends JPanel {

    private JLabel history = new JLabel();

    public MoveHistoryPanel(){
        this.add(history);
        history.setText("History");
        history.setPreferredSize(new Dimension(600, 60));
        history.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    public void updateMoves(){
        history.setText(GameState.getHistory().printMoves());
        this.setVisible(true);
        history.setVisible(true);
        revalidate();
        repaint();
    }

}
