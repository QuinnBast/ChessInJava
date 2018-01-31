package gui.Menu.FileMenu.Buttons;

import Engine.Board.ChessBoard;
import gui.Window.Window;
import gui.Window.WindowLayers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quinn on 1/30/2018.
 */
public class NewGameButton extends JMenuItem {

    public NewGameButton(){
        this.setText("New Game");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This is what happens when you click the "New Game" Button
                ChessBoard.newGame();
                gui.Window.Window.updateWindow();
            }
        });

    }

}
