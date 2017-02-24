package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class Knight extends Piece {
	public Knight(String owner, int posx, int posy){
		super(owner, "Knight", posx, posy);
	}
	
	
	@Override
	public ArrayList<Location> getPossibleMoves(ChessBoard theBoard){
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		if ((x+2 < 8) && (y+1 < 8)){
			if ((theBoard.getPieceAtLocation(x+2, y+1) == null) 
				|| (theBoard.getPieceAtLocation(x+2, y+1).getColor() != this.getColor())){
				possibleMoves.add(new Location(x+2, y+1));
			}
		}
		if ((x+2 < 8) && (y-1 >= 0)){
			if (theBoard.getPieceAtLocation(x+2, y-1) == null 
				|| (theBoard.getPieceAtLocation(x+2, y-1).getColor() != this.getColor())){
				possibleMoves.add(new Location(x+2, y-1));
			}
		}
		if ((x-2 >= 0) && (y+1 < 8)){
			if (theBoard.getPieceAtLocation(x-2, y+1) == null
				|| (theBoard.getPieceAtLocation(x-2, y+1).getColor() != this.getColor())){
				possibleMoves.add(new Location(x-2, y+1));
			}
		}
		if ((x-2 >= 0) && (y-1 >= 0)){
			if (theBoard.getPieceAtLocation(x-2, y-1) == null
				|| (theBoard.getPieceAtLocation(x-2, y-1).getColor() != this.getColor())){
				possibleMoves.add(new Location(x-2, y-1));
			}
		}
		if ((x+1 < 8) && (y+2 < 8)){
			if (theBoard.getPieceAtLocation(x+1, y+2) == null 
				|| (theBoard.getPieceAtLocation(x+1, y+2).getColor() != this.getColor())){
				possibleMoves.add(new Location(x+1, y+2));
			}
		}
		if ((x+1 < 8) && (y-2 >= 0)){
			if (theBoard.getPieceAtLocation(x+1, y-2) == null 
				|| (theBoard.getPieceAtLocation(x+1, y-2).getColor() != this.getColor())){
				possibleMoves.add(new Location(x+1, y-2));
			}
		}
		if ((x-1 >= 0) && (y+2 < 8)){
			if (theBoard.getPieceAtLocation(x-1, y+2) == null 
				|| (theBoard.getPieceAtLocation(x-1, y+2).getColor() != this.getColor())){
				possibleMoves.add(new Location(x-1, y+2));
			}
		}
		if ((x-1 >= 0) && (y-2 >= 0)){
			if (theBoard.getPieceAtLocation(x-1, y-2) == null 
				|| (theBoard.getPieceAtLocation(x-1, y-2).getColor() != this.getColor())){
				possibleMoves.add(new Location(x-1, y-2));
			}
		}
		return possibleMoves;
	}

}
