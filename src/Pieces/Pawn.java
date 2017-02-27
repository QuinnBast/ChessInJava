package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class Pawn extends Piece {
	public Pawn(String owner, int posx, int posy){
		super(owner, "Pawn", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(){
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		//White pawns
		if (this.getColor() == "white"){
			//check 1 forward
			if (ChessBoard.getPieceAtLocation(x, y+1) == null){
				possibleMoves.add(new Location(x, y+1));
			}
			//Can the pawn move 2 spaces?
			if (this.getLocation().getY() == 1){
				//is there something already there?
				if(ChessBoard.getPieceAtLocation(x, y+2) == null){
					possibleMoves.add(new Location(x, y+2));
				}
			}
			//Can the pawn attack something?
			//No pieces will be off the board so we don't have to check bounds
			if (ChessBoard.getPieceAtLocation(x+1, y+1) != null){
				possibleMoves.add(new Location(x+1, y+1));
			}
			if (ChessBoard.getPieceAtLocation(x-1, y+1) != null){
				possibleMoves.add(new Location(x-1, y+1));
			}
			return possibleMoves;
		}
		
		//Black Pawns
		else if (this.getColor() == "black"){
			//check 1 forward(down for black)
			if (ChessBoard.getPieceAtLocation(x, y-1) == null){
				possibleMoves.add(new Location(x, y-1));
			}
			//Can the pawn move 2 spaces?
			if (this.getLocation().getY() == 6){
				//is there something already there?
				if(ChessBoard.getPieceAtLocation(x, y-2) == null){
					possibleMoves.add(new Location(x, y-2));
				}
			}
			//Can the pawn attack something?
			if (ChessBoard.getPieceAtLocation(x+1, y-1) != null){
				possibleMoves.add(new Location(x+1, y-1));
			}
			if (ChessBoard.getPieceAtLocation(x-1, y-1) != null){
				possibleMoves.add(new Location(x-1, y-1));
			}
			return possibleMoves;
		}
		else{
		return null;
		}
	}
	

}
