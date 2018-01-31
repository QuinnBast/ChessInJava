package gui.Menu.FileMenu.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quinn on 1/30/2018.
 */
public class ExitGameButton extends JMenuItem {

    public ExitGameButton(){
        this.setText("Exit Game");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This is what happens when you click the "Quit Game" Button
                System.exit(0);
            }
        });
    }

}
