package gui.Menu;

import javax.swing.JMenuBar;

import gui.Menu.EditMenu.EditMenu;
import gui.Menu.FileMenu.FileMenu;

public class MenuGui extends JMenuBar {
	
	public MenuGui(){
		this.add(new FileMenu());
		this.add(new EditMenu());
	}
}
