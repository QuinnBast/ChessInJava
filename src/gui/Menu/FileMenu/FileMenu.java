package gui.Menu.FileMenu;

import gui.Menu.FileMenu.Buttons.ExitGameButton;
import gui.Menu.FileMenu.Buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/30/2018.
 */
public class FileMenu extends JMenu {

    public FileMenu(){
        this.setText("File");
        this.add(new NewGameButton());
        this.add(new ExitGameButton());
    }
}
