package Engine;

import Pieces.King;

public class GameState {
	private String currentMove;
	private String gameState;
	
	public GameState(){
		this.currentMove = "white";
		this.gameState = "inGame";
	}
	
	public String getCurrentPlayer(){
		return currentMove;
	}
	
	public void switchPlayer(){
		King opposingKing = ChessBoard.getKing(currentMove);
		if(opposingKing.isInCheck()){
			this.currentMove = (this.currentMove == "white") ? "black" : "white";
			gameState = currentMove + " Wins";
			System.out.println(gameState);
			return;
		}
		this.currentMove = (this.currentMove == "white") ? "black" : "white";
	}
}
