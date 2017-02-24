package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class Pawn extends Piece {
	public Pawn(String owner, int posx, int posy){
		super(owner, "Pawn", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(int x, int y, ChessBoard theBoard){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		//White pawns
		if (this.getColor() == "white"){
			//check 1 forward
			if (theBoard.getPieceAtLocation(x, y+1) == null){
				possibleMoves.add(new Location(x, y+1));
			}
			//Can the pawn move 2 spaces?
			if (this.getLocation().getY() == 1){
				//is there something already there?
				if(theBoard.getPieceAtLocation(x, y+2) == null){
					possibleMoves.add(new Location(x, y+2));
				}
			}
			//Can the pawn attack something?
			//No pieces will be off the board so we don't have to check bounds
			if (theBoard.getPieceAtLocation(x+1, y+1) != null){
				possibleMoves.add(new Location(x+1, y+1));
			}
			if (theBoard.getPieceAtLocation(x-1, y+1) != null){
				possibleMoves.add(new Location(x-1, y+1));
			}
			return possibleMoves;
		}
		
		//Black Pawns
		else if (this.getColor() == "black"){
			//check 1 forward(down for black)
			if (theBoard.getPieceAtLocation(x, y-1) == null){
				possibleMoves.add(new Location(x, y-1));
			}
			//Can the pawn move 2 spaces?
			if (this.getLocation().getY() == 6){
				//is there something already there?
				if(theBoard.getPieceAtLocation(x, y-2) == null){
					possibleMoves.add(new Location(x, y-2));
				}
			}
			//Can the pawn attack something?
			if (theBoard.getPieceAtLocation(x+1, y-1) != null){
				possibleMoves.add(new Location(x+1, y-1));
			}
			if (theBoard.getPieceAtLocation(x-1, y-1) != null){
				possibleMoves.add(new Location(x-1, y-1));
			}
			return possibleMoves;
		}
		else{
		return null;
		}
	}
	

}
