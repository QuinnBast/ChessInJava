package gui.Menu.EditMenu;

import gui.Menu.EditMenu.Buttons.RedoButton;
import gui.Menu.EditMenu.Buttons.UndoButton;

import javax.swing.*;

/**
 * Created by Quinn on 2/16/2018.
 */
public class EditMenu extends JMenu {

    public EditMenu(){
        this.setText("Edit");
        this.add(new UndoButton());
        this.add(new RedoButton());
    }

}
