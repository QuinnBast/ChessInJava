package gui.Menu.EditMenu.Buttons;

import Engine.GameState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quinn on 2/16/2018.
 */
public class UndoButton extends JMenuItem {

    public UndoButton(){
        this.setText("Undo");


        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.history.undo();
            }
        });

    }
}
