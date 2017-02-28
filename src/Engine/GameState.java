package Engine;

import Pieces.King;

public class GameState {
	private String currentMove;
	private String gameState;
	private boolean currentPlayerIsInCheck = false; 
	
	public GameState(){
		this.currentMove = "white";
		this.gameState = "inGame";
	}
	
	public String getCurrentPlayer(){
		return currentMove;
	}
	
	public void switchPlayer(){
		if(ChessBoard.getKing(currentMove).isInCheck()){
			this.currentMove = (this.currentMove == "white") ? "black" : "white";
			gameState = currentMove + " Wins";
			System.out.println(gameState);
			return;
		}
		this.currentMove = (this.currentMove == "white") ? "black" : "white";
		if(ChessBoard.getKing(currentMove).isInCheck()){
			System.out.println("You are in check!");
			setCurrentPlayerInCheck(true);
		} else {setCurrentPlayerInCheck(false);}
	}

	public boolean getCurrentPlayerInCheck() {
		return currentPlayerIsInCheck;
	}

	public void setCurrentPlayerInCheck(boolean currentPlayerIsInCheck) {
		this.currentPlayerIsInCheck = currentPlayerIsInCheck;
	}
}
