package Engine;
import java.util.ArrayList;

import Pieces.*;

public class ChessBoard{
	private ArrayList<Piece> board = new ArrayList<Piece>();
	
	public ChessBoard(){
		for (int i=0; i<8; i++)
		{
			board.add(new Pawn("white", 1, i));
			board.add(new Pawn("black", 6, i));
		}
		board.add(new Rook("black", 7, 0));
		board.add(new Knight("black", 7, 1));
		board.add(new Bishop("black", 7, 2));
		board.add(new Queen("black", 7, 3));
		board.add(new King("black", 7, 4));
		board.add(new Bishop("black", 7, 5));
		board.add(new Knight("black", 7, 6));
		board.add(new Rook("black", 7, 7));
		
		board.add(new Rook("white", 0, 0));
		board.add(new Knight("white", 0, 1));
		board.add(new Bishop("white", 0, 2));
		board.add(new Queen("white", 0, 3));
		board.add(new King("white", 0, 4));
		board.add(new Bishop("white", 0, 5));
		board.add(new Knight("white", 0, 6));
		board.add(new Rook("white", 0, 7));
	}
	
	public Piece getPieceAtLocation(int x, int y){
		for(int i=0; i<board.size(); i++)
		{
			if (board.get(i).getXpos() == x && board.get(i).getYpos() == y)
			{
				return board.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Piece> getBoard(){
		return board;
	}

}
	