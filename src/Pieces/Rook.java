package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class Rook extends Piece {
	public Rook(String owner, int posx, int posy){
		super(owner, "Rook", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(){
		boolean collision = false;
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		int checkx = this.getLocation().getX();
		int checky = this.getLocation().getY();
		
		int checkRows = 0;
		while (checkRows < 4){
			while(!collision){
				//consider each diagonal and check the open squares
				switch(checkRows){
				case 0:
					checkx++;
					break;
				case 1:
					checkx--;
					break;
				case 2:
					checky++;
					break;
				case 3:
					checky--;
					break;
				}
				if ((checkx < 8) && (checky < 8) && (checkx >= 0) && (checky >= 0)){
					if (ChessBoard.getPieceAtLocation(checkx,checky)==null ){
						possibleMoves.add(new Location(checkx, checky));
					}
					else{
					//The rook can still capture the piece if it is of the opposing color.
						if (this.getColor() != ChessBoard.getPieceAtLocation(checkx,checky).getColor()){
							possibleMoves.add(new Location(checkx, checky));
						}
						//But the rook cannot jump pieces.
						collision = true;
					}
				}
				else{
				//we've gone too far! We're outside the grid
				collision = true;
				}
			}//Done checking one direction, go to the next
			collision = false;
			checkx = this.getLocation().getX();
			checky = this.getLocation().getY();
			checkRows++;
		}//End of check
		return possibleMoves;
	}
}
