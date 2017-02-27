package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class King extends Piece {
	public King(String owner, int posx, int posy){
		super(owner, "King", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(){
		
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		
		int checksquares = 0;
		int currx = this.getLocation().getX();
		int curry = this.getLocation().getY();
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		
		
		while(checksquares < 8){
				switch(checksquares){
				case 0:
					x = this.getLocation().getX() - 1;
					y = this.getLocation().getY() + 1;
					break;
				case 1:
					x = this.getLocation().getX();
					y = this.getLocation().getY() + 1;
					break;
				case 2:
					x = this.getLocation().getX() + 1;
					y = this.getLocation().getY() + 1;
					break;
				case 3:
					x = this.getLocation().getX() + 1;
					y = this.getLocation().getY();
					break;
				case 4:
					x = this.getLocation().getX() + 1;
					y = this.getLocation().getY() - 1;
					break;
				case 5:
					x = this.getLocation().getX();
					y = this.getLocation().getY() - 1;
					break;
				case 6:
					x = this.getLocation().getX() - 1;
					y = this.getLocation().getY() - 1;
					break;
				case 7:
					x = this.getLocation().getX() - 1;
					y = this.getLocation().getY();
					break;
					
				}
				//check x and y
				//check if collision with own piece,
				//move, check if in check, move back
				//capture opponent(if exist), check in check, move back
				if ((x < 8) && (y < 8)&& (x >= 0) && (y >= 0)){
					if (ChessBoard.getPieceAtLocation(x, y) == null){
						//move piece
						this.getLocation().setX(x);
						this.getLocation().setY(y);
						//is king in check at new location?
						if(!isInCheck()){
							//if the king is not in check at the new location, add it
							possibleMoves.add(new Location(x, y));
						}
						//move back
						this.getLocation().setX(currx);
						this.getLocation().setY(curry);
					}
					//if there is a piece at the location and it is an enemy, check if it can be captured
					else if (ChessBoard.getPieceAtLocation(x, y).getColor() != this.getColor()){
						//Save the opponent's piece
						Piece removedPiece = ChessBoard.getPieceAtLocation(x, y);
						
						ChessBoard.board.remove(removedPiece);
						this.getLocation().setX(x);
						this.getLocation().setY(y);
						//is king in check at new location?
						if(!isInCheck()){
							//if the king can safely capture the other piece, add this square to possible locations
							possibleMoves.add(new Location(x, y));
						}
						//move back and add removed piece back
						this.getLocation().setX(currx);
						this.getLocation().setY(curry);
						ChessBoard.board.add(removedPiece);
					}
				}
			checksquares++;
		}
		return possibleMoves;
	}
	
	private boolean isInCheck(){		
		for (int i=0; i<ChessBoard.board.size(); i++){
			//Loop through each piece on the board.
			Piece thePiece = ChessBoard.board.get(i);
			//If the piece is not the color of the king, check the locations which that piece can move to.
			if (thePiece.getColor() != this.getColor()){
				ArrayList<Location> temp = thePiece.getPossibleMoves();
				for (int j=0; j<temp.size(); j++){
					//for each possible location, if it can move to the king's square, the king is in check.
					if ((this.getLocation().getX() == temp.get(j).getX()) && (this.getLocation().getY() == temp.get(j).getY())){
						return true;
					}
					}
				}
			}
		return false;
		}
	
}
