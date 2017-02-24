import Engine.ChessBoard;
import gui.*;

public class PlayChess {
	public static ChessBoard theBoard = new ChessBoard();
	public static userGui gui = new userGui();
	
	public static void main(String args[]){
		System.out.println(theBoard.getPieceAtLocation(4, 0));
		System.out.println(theBoard.getPieceAtLocation(4, 0).getPossibleMoves(theBoard));
		System.out.println(theBoard.getPieceAtLocation(4, 1));
		System.out.println(theBoard.getPieceAtLocation(4, 1).getPossibleMoves(theBoard));
	}
}
