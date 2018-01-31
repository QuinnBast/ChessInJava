package Engine.Board.Pieces;

import java.util.ArrayList;

import Engine.Board.ChessBoard;

public class Bishop extends Piece {
	public Bishop(String owner, int posx, int posy){
		super(owner, "Bishop", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(){
		boolean collision = false;
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		int checkx = this.getLocation().getX();
		int checky = this.getLocation().getY();
		
		int checkDiagonals = 0;
		while (checkDiagonals < 4){
			while(!collision){
				//consider each diagonal and check the open squares
				switch(checkDiagonals){
				case 0:
					checkx++;
					checky++;
					break;
				case 1:
					checkx++;
					checky--;
					break;
				case 2:
					checkx--;
					checky++;
					break;
				case 3:
					checkx--;
					checky--;
					break;
				}
				if ((checkx < 8) && (checky < 8)&& (checkx >= 0) && (checky >= 0)){
					if (ChessBoard.getPieceAtLocation(checkx,checky)==null ){
						possibleMoves.add(new Location(checkx, checky));
					}
					else{
					//The bishop can still capture the piece if it is of the opposing color.
						if (this.getColor() != ChessBoard.getPieceAtLocation(checkx,checky).getColor()){
							possibleMoves.add(new Location(checkx, checky));
						}
					//But the bishop cannot jump the piece.
					collision = true;
					}
				}
				else{
				//we've gone too far! We're outside the grid
				collision = true;
				}
				}//End while loop for collisions
				collision = false;
				checkx = this.getLocation().getX();
				checky = this.getLocation().getY();
				checkDiagonals++;
			}
		return possibleMoves;
	}
}
