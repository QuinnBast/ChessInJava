package Engine;
import java.util.ArrayList;

import Pieces.*;

public class ChessBoard{
	public static ArrayList<Piece> board = new ArrayList<Piece>();
	private GameState theState = new GameState();
	
	public ChessBoard(){
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
	
	public void clearBoard(){
		ChessBoard.board.clear();
	}
	
	public static boolean move(Piece thePiece, Location here){
		ArrayList<Location> pieceLocations = thePiece.getPossibleMoves();
		for (int i=0; i<pieceLocations.size(); i++){
			//loop through all of the piece's possible locations
			
			if (here.getX() == pieceLocations.get(i).getX() && here.getY() == pieceLocations.get(i).getY()){
				//If you have selected a valid location to move to:
				//is there an opponent's piece there to capture?
				if (getPieceAtLocation(here.getX(), here.getY()) != null){
					//there is a piece there, lets remove it!
					board.remove(getPieceAtLocation(here.getX(), here.getY()));
				}
				//move the piece and return
				thePiece.setLocation(here.getX(), here.getY());
				return true;
			}
		}
		//The location you have selected is not possible to move to.
		return false;
	}
	
	public GameState getGameState(){
		return this.theState;
	}
}
	