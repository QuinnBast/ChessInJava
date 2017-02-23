package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private final BoardPanel boardPanel;
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);
	private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(50,50);
	private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
	
	//Object for the menu bar
	final JMenuBar menuBar = new JMenuBar();

	//Constructor to set up the window
	public userGui(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.populateMenu();
		this.window.setJMenuBar(menuBar);
		
		this.boardPanel = new BoardPanel();
		this.window.add(this.boardPanel, BorderLayout.CENTER);		
		this.window.setVisible(true);
	}
	
	private void populateMenu(){
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
	
	private class BoardPanel extends JPanel{
		
		BoardPanel(){
			super(new GridLayout(8,8));
			for(int i=0; i<8; i++){
				//Add a new tile panel for each square on the board.
				for(int j=0; j<8; j++){
					add(new TilePanel(i, j));
				}
			}
			setPreferredSize(BOARD_PANEL_DIMENSION);
			validate();
		}
	}
	
	private class TilePanel extends JPanel{
		
		TilePanel(int i, int j){
			super(new GridBagLayout());
			setPreferredSize(TILE_PANEL_DIMENSION);
			if (i % 2 == 0){
				if (j % 2 == 0){
					setBackground(Color.BLACK);
				}
				else{

					setBackground(Color.WHITE);
				}
			}
			else{
				if (j % 2 == 0){
					setBackground(Color.WHITE);
				}
				else{
					setBackground(Color.BLACK);
				}
			}
			
		}
		
	}
	
}
