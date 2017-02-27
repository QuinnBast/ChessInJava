import java.util.ArrayList;

import Engine.ChessBoard;
import Engine.GameState;
import Pieces.Piece;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui(theBoard);
	public static GameState state = new GameState();
	
	public static void main(String args[]){
	}
}
