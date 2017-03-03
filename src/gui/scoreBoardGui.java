package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.ChessBoard;

public class scoreBoardGui {
	private final scorePanel score = new scorePanel();

	public scorePanel getPanel(){
		return this.score;
	}
	
	public class scorePanel extends JPanel{
		private JPanel whiteScore = new JPanel();
		private JPanel blackScore = new JPanel();
		
		//labels for each panel
		private JLabel whitePanel = new JLabel();
		private JLabel blackPanel = new JLabel();
	
		scorePanel(){
			this.setSize(new Dimension(600, 75));
			this.setVisible(true);
			this.setBackground(Color.LIGHT_GRAY);
			whiteScore.setBackground(Color.LIGHT_GRAY);
			blackScore.setBackground(Color.LIGHT_GRAY);
	
			updateScore();
			this.whiteScore.add(whitePanel);
			this.blackScore.add(blackPanel);
			this.add(whiteScore);
			this.add(blackScore);
			this.validate();
			this.repaint();
		}
		
		
		public void updateScore(){
			whitePanel.setText("<html><p>White</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getWhiteWins() + "</p></html>");
			blackPanel.setText("<html><p>Black</p><p style='text-align: center; width: 100%'>" + ChessBoard.theState.getBlackWins() + "</p></html>");
		}
	}
	
}
