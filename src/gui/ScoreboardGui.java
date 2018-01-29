package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;
import Engine.GameState;
import Engine.GameStates.Gamestates;

public class ScoreboardGui {
	private final scorePanel score = new scorePanel();

	public scorePanel getPanel(){
		return this.score;
	}
	
	public class scorePanel extends JPanel{
		private JPanel WhiteScore = new JPanel();
		private JPanel BlackScore = new JPanel();
		private JPanel inCheck = new JPanel();
		
		//labels for each panel
		private JLabel WhitePanel = new JLabel();
		private JLabel BlackPanel = new JLabel();
		private JLabel inCheckText = new JLabel("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>In Check!</p></html>");
	
		scorePanel(){
			initializeThis();
			updateScore();
			this.add(inCheck);	//For some reason I have to add this first for it to be on the left.
			this.add(WhiteScore);			
			this.add(BlackScore);
			this.validate();
			this.repaint();
		}
		
		
		public void updateScore(){
			WhitePanel.setText("<html><p>White</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getWhiteWins() + "</p></html>");
			BlackPanel.setText("<html><p>Black</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getBlackWins() + "</p></html>");
			if (ChessBoard.theState.getGameState() != Gamestates.INGAME){
				inCheckText.setText("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>"+ChessBoard.theState.getGameState().toString()+"</p></html>");
			} else { inCheckText.setText("<html><p style='color: red; font-size: 16px; margin-right: 60px;'>In Check!</p></html>"); }
			if (ChessBoard.theState.getCurrentPlayerInCheck() || ChessBoard.theState.getGameState() != Gamestates.INGAME){
				inCheck.setVisible(true);
			} else {
				inCheck.setVisible(false);
			}	
		}
		
		private void initializeThis(){
			this.setSize(new Dimension(600, 75));
			this.setVisible(true);
			this.setBackground(Color.LIGHT_GRAY);
			this.setLayout(new GridBagLayout());
			WhiteScore.setBackground(Color.LIGHT_GRAY);
			BlackScore.setBackground(Color.LIGHT_GRAY);
			inCheck.setBackground(Color.LIGHT_GRAY);
			this.WhiteScore.add(WhitePanel);
			this.BlackScore.add(BlackPanel);
			inCheck.add(inCheckText);
		}
	}
	
}
