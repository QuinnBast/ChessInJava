package Engine.Board.Pieces;

import java.util.ArrayList;

import Engine.Board.ChessBoard;

public class Pawn extends Piece {
	public Pawn(String owner, int posx, int posy){
		super(owner, "Pawn", posx, posy);
	}
	private boolean movedTwice = false;
	
	@Override
	public ArrayList<Location> getPossibleMoves(){
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		//White pawns
		if (this.getColor() == "White"){
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
			//Check if there is a pawn that can be capture EnPassant
			if(
					(ChessBoard.getPieceAtLocation(x+1, y) != null &&
					ChessBoard.getPieceAtLocation(x+1, y) instanceof Pawn &&
					((Pawn)ChessBoard.getPieceAtLocation(x+1, y)).getMovedTwice() == true)
					||
					(ChessBoard.getPieceAtLocation(x-1, y) != null &&
					ChessBoard.getPieceAtLocation(x-1, y) instanceof Pawn &&
					((Pawn)ChessBoard.getPieceAtLocation(x-1, y)).getMovedTwice() == true)
			  ){
				//There is a pawn that can be captured enPassant.
				if(ChessBoard.getPieceAtLocation(x-1, y) != null) {
					Location location = new Location(x -1, y + 1);
					location.setEnPassant();
					possibleMoves.add(location);
				} else {
					Location location = new Location(x +1, y + 1);
					location.setEnPassant();
					possibleMoves.add(location);
				}
			}

			return possibleMoves;
		}
		
		//Black Pawns
		else if (this.getColor() == "Black"){
			//check 1 forward(down for Black)
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

			//Check if there is a pawn that can be capture EnPassant
			if(
				(ChessBoard.getPieceAtLocation(x+1, y) != null &&
				ChessBoard.getPieceAtLocation(x+1, y) instanceof Pawn &&
				((Pawn)ChessBoard.getPieceAtLocation(x+1, y)).getMovedTwice() == true)
				||
				(ChessBoard.getPieceAtLocation(x-1, y) != null &&
				ChessBoard.getPieceAtLocation(x-1, y) instanceof Pawn &&
				((Pawn)ChessBoard.getPieceAtLocation(x-1, y)).getMovedTwice() == true)
				){
				//There is a pawn that can be captured enPassant.
				if(ChessBoard.getPieceAtLocation(x-1, y) != null) {
					Location location = new Location(x -1, y - 1);
					location.setEnPassant();
					possibleMoves.add(location);
				} else {
					Location location = new Location(x +1, y - 1);
					location.setEnPassant();
					possibleMoves.add(location);
				}
			}

			return possibleMoves;
		}
		else{
		return null;
		}
	}

	public void setMovedTwice(boolean value){
		this.movedTwice = value;
	}

	public boolean getMovedTwice(){
		return this.movedTwice;
	}

}
