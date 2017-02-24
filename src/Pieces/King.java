package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class King extends Piece {
	public King(String owner, int posx, int posy){
		super(owner, "King", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(int x, int y, ChessBoard theBoard){
		
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		ArrayList<Location> opponentsMoves = new ArrayList<Location>();
		
		//THE KING CANNOT MOVE INTO CHECK.
		//NEED "getPossibleMoves" for all Opponent's pieces
		//Compare all opponent moves (and all pieces on board) to possible locations
		for(int i=0; i<theBoard.getBoard().size(); i++){
			//For each piece on the board, if it is an enemy add their possible moves to the list
			
			//The king can also capture pieces that are not protected by an enemies piece.
			//Jesus this is complicated.
			
		}
		
	}
	
}
