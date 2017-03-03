package Engine;
import java.util.ArrayList;

import Pieces.*;

public class ChessBoard{
	public static ArrayList<Piece> board = new ArrayList<Piece>();
	public static ArrayList<Piece> takenPieces = new ArrayList<Piece>();
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
			board.add(new Pawn("White", i, 1));
			board.add(new Pawn("Black", i, 6));
		}
		board.add(new Rook("Black", 0, 7));
		board.add(new Knight("Black", 1, 7));
		board.add(new Bishop("Black", 2, 7));
		board.add(new Queen("Black", 4, 7));
		board.add(new King("Black", 3, 7));
		board.add(new Bishop("Black", 5, 7));
		board.add(new Knight("Black", 6, 7));
		board.add(new Rook("Black", 7, 7));
		
		board.add(new Rook("White", 0, 0));
		board.add(new Knight("White", 1, 0));
		board.add(new Bishop("White", 2, 0));
		board.add(new Queen("White", 3, 0));
		board.add(new King("White", 4, 0));
		board.add(new Bishop("White", 5, 0));
		board.add(new Knight("White", 6, 0));
		board.add(new Rook("White", 7, 0));
		
		theState.setGameState("inGame");
		theState.setCurrentPlayer("White");
		theState.setCurrentPlayerInCheck(false);
		takenPieces.clear();
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
	