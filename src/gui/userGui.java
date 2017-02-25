package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class userGui {
	//Create an object for the window
	private final JFrame window = new JFrame();
	private MenuGui menuGui = new MenuGui();
	private BoardGui boardGui = new BoardGui();
	
	//constants for the dimensions
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

	//Constructor to set up the window
	public userGui(){
		this.window.setSize(OUTER_FRAME_DIMENSION);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setJMenuBar(menuGui.getMenu()); //Get the menu from the menuGui class
		this.window.setTitle("Chess");
		this.window.add(boardGui.getBoardBackground(), BorderLayout.CENTER);
		
		//Add the image of a pawn to the frame
		//This overrwrites the chess board.
		BufferedImage img = null;
		try{
			img = ImageIO.read(getClass().getResource("/Images/WhitePawn.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(img);
		JLabel label = new JLabel();
		label.setIcon(icon);
		this.window.getContentPane().add(label,  BorderLayout.CENTER);
		
		//To ADD AN IMAGE (ABOVE):
		//JFrame(ContentPane)->Jlabel->ImageIcon->BufferedImage
		
		//Set the window's Icon
		this.window.setIconImage(
			    new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
		
		this.window.setVisible(true);
		

		System.out.println(this.getClass().getResource("/Images/WhitePawn.png"));
	}
	
}
