package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuGui {
	//Object for the menu bar
	final JMenuBar menuBar = new JMenuBar();
	
	public MenuGui(){
		menuBar.add(createFileMenu());
	}
	
	private JMenu createFileMenu(){
		final JMenu fileMenu = new JMenu("File"); //A menu
		
		final JMenuItem newGame = new JMenuItem("New Game"); //A menu Item
		newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//This is what happens when you click the "New Game" Button
				System.out.println("New Game Started");
			}
		});
		fileMenu.add(newGame);
		
		final JMenuItem exitMenu = new JMenuItem("Exit"); //A menu Item
		newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//This is what happens when you click the "New Game" Button
				System.out.println("Quit the game");
			}
		});
		fileMenu.add(exitMenu);
		
		return fileMenu;
	}
	
	public JMenuBar getMenu(){
		return menuBar;
	}

}
