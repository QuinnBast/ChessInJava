package gui;
import gui.Menu.MenuGui;
import gui.Modals.ModalController;
import gui.Modals.PromotionPanel;
import gui.MoveHistory.MoveHistoryPanel;
import gui.TakenPieces.TakenPiecePanel;
import gui.Window.Window;

import java.awt.Dimension;

import javax.swing.*;

public class userGui {
	//Create an object for the window
	private static final Window window = new Window();
	public static ModalController modalController = new ModalController();

	//Constructor to set up the window
	public userGui(){
		window.updateWindow();
	}

	public JFrame getWindow(){
		return window;
	}



}
