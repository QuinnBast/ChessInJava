package Engine;
import java.util.ArrayList;

import Pieces.*;

public class ChessBoard{
	public static ArrayList<Piece> board = new ArrayList<Piece>();
	public static GameState theState = new GameState();
	
	public ChessBoard(){
		newGame();
	}
	
	public static Piece getPieceAtLocation(int x, int y){
		for(int i=0; i<board.size(); i++)
		{
			if (board.get(i).getLocation().getX() == x && board.get(i).getLocation().getY() == y)
			{
				return board.get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<Piece> getBoard(){
		return board;
	}
	
	public ArrayList<Location> getPossibleMoves(int x, int y){
		Piece thePiece = getPieceAtLocation(x,y);
		if(thePiece != null){
			return thePiece.getPossibleMoves();
		}
		return null;
	}	
	
	public static void clearBoard(){
		ChessBoard.board.clear();
	}
	
	public GameState getGameState(){
		return this.theState;
	}
	
	public static void newGame(){
		clearBoard();
		for (int i=0; i<8; i++)
		{
			board.add(new Pawn("white", i, 1));
			board.add(new Pawn("black", i, 6));
		}
		board.add(new Rook("black", 0, 7));
		board.add(new Knight("black", 1, 7));
		board.add(new Bishop("black", 2, 7));
		board.add(new Queen("black", 4, 7));
		board.add(new King("black", 3, 7));
		board.add(new Bishop("black", 5, 7));
		board.add(new Knight("black", 6, 7));
		board.add(new Rook("black", 7, 7));
		
		board.add(new Rook("white", 0, 0));
		board.add(new Knight("white", 1, 0));
		board.add(new Bishop("white", 2, 0));
		board.add(new Queen("white", 3, 0));
		board.add(new King("white", 4, 0));
		board.add(new Bishop("white", 5, 0));
		board.add(new Knight("white", 6, 0));
		board.add(new Rook("white", 7, 0));
		
		theState.setGameState("inGame");
	}
	
	public static ArrayList<Location> getPlayersPossibleMoves(String color){
		ArrayList<Location> playersMoves = new ArrayList<Location>();
		for (int i=0; i<board.size(); i++){
			if (board.get(i).getColor() == color){
				playersMoves.addAll(board.get(i).getPossibleMoves());
			}
		}
		return playersMoves;
	}
	
	public static King getKing(String color){
		for (int i=0; i<ChessBoard.board.size(); i++){
			if (ChessBoard.board.get(i).getName() == "King"){
				if(ChessBoard.board.get(i).getColor() == color){
					return (King) ChessBoard.board.get(i);
				}
			}
		}
		return null;
	}
}
	