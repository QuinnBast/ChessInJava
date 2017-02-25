import Engine.ChessBoard;
import Pieces.*;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui();
	
	public static void main(String args[]){
		theBoard.clearBoard();
		theBoard.getBoard().add(new Rook("white", 2, 3));
		theBoard.getBoard().add(new King("black", 3, 4));
		System.out.println(theBoard.getPieceAtLocation(2, 3));
		System.out.println(theBoard.getPieceAtLocation(3, 4).getPossibleMoves(theBoard));
	}
}
