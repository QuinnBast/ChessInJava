import Engine.ChessBoard;
import Pieces.*;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui();
	
	public static void main(String args[]){
		theBoard.clearBoard();
		theBoard.getBoard().add(new King("white", 4, 4));
		theBoard.getBoard().add(new Bishop("black", 4,5));
		System.out.println(theBoard.getPieceAtLocation(4, 4));
		System.out.println(theBoard.getPieceAtLocation(4, 4).getPossibleMoves(theBoard));
	}
}
