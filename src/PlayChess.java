import Engine.ChessBoard;
import Engine.GameState;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui(theBoard);
	public static GameState state = new GameState();
	
	public static void main(String args[]){
		while(true){
		gui.updateBoard(theBoard);
		}
	}
}
