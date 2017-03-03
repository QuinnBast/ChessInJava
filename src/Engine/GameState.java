package Engine;

import Pieces.King;

public class GameState {
	private String currentMove;
	private String gameState;
	private boolean currentPlayerIsInCheck = false; 
	private int whiteWins = 0;
	private int blackWins = 0;
	
	public GameState(){
		this.currentMove = "White";
		this.gameState = "inGame";
	}
	
	public String getCurrentPlayer(){
		return currentMove;
	}
	
	public void setCurrentPlayer(String player){
		this.currentMove = player;
	}
	
	public void switchPlayer(){
		//check if the game is over
		if(ChessBoard.getKing(currentMove).isInCheck()){
			this.currentMove = (this.currentMove == "White") ? "Black" : "White";
			gameState = currentMove + " Wins";
			if(currentMove == "White"){this.whiteWins++;}else{blackWins++;}
			System.out.println(gameState);
			return;
		}
		//switch players
		this.currentMove = (this.currentMove == "White") ? "Black" : "White";
		
		if (ChessBoard.getPlayersPossibleMoves(currentMove) == null){
			this.currentMove = (this.currentMove == "White") ? "Black" : "White";
			gameState = currentMove + " Wins";
			if(currentMove == "White"){this.whiteWins++;}else{blackWins++;}
			System.out.println(gameState);
			return;
		}
		
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
	
	public String getGameState(){
		return this.gameState;
	}
	
	public void setGameState(String state){
		this.gameState = state;
	}
	
	public int getWhiteWins(){
		return whiteWins;
	}
	
	public int getBlackWins(){
		return blackWins;
	}
}
