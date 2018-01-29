package gui;

import Engine.GameState;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/28/2018.
 */
public class MoveHistoryGui extends JPanel {

    private JLabel history = new JLabel();

    MoveHistoryGui(){
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
