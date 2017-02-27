package Engine;

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
		this.currentMove = (this.currentMove == "white") ? "black" : "white";
	}
}
