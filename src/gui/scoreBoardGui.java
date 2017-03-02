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
			this.setBackground(Color.BLUE);
			updateScore();
			this.whiteScore.add(whitePanel);
			this.blackScore.add(blackPanel);
			this.add(whiteScore);
			this.add(blackScore);
			this.validate();
			this.repaint();
		}
		
		
		public void updateScore(){
			whitePanel.setText("" + ChessBoard.theState.getWhiteWins());
			blackPanel.setText("" + ChessBoard.theState.getBlackWins());
		}
	}
	
}
