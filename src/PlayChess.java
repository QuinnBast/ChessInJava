import Engine.ChessBoard;
import Pieces.*;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui();
	
	public static void main(String args[]){
		gui.updateBoard(theBoard);
	}
}
