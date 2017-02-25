package Engine;
import java.util.ArrayList;

import Pieces.*;

public class ChessBoard{
	private ArrayList<Piece> board = new ArrayList<Piece>();
	
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
	
	public Piece getPieceAtLocation(int x, int y){
		for(int i=0; i<board.size(); i++)
		{
			if (board.get(i).getLocation().getX() == x && board.get(i).getLocation().getY() == y)
			{
				return board.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Piece> getBoard(){
		return board;
	}
	
	public ArrayList<Location> getPossibleMoves(int x, int y){
		Piece thePiece = getPieceAtLocation(x,y);
		if(thePiece != null){
			return thePiece.getPossibleMoves(this);
		}
		return null;
	}	
	
	public void clearBoard(){
		this.board.clear();
	}
}
	