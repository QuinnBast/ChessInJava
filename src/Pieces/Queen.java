package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public class Queen extends Piece {
	public Queen(String owner, int posx, int posy){
		super(owner, "Queen", posx, posy);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoves(int x, int y, ChessBoard theBoard){
		boolean collision = false;
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		int checkx = x;
		int checky = y;
		
		int checkRows = 0;
		while (checkRows < 8){
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
				case 4:
					checkx++;
					checky++;
					break;
				case 5:
					checkx++;
					checky--;
					break;
				case 6:
					checkx--;
					checky++;
					break;
				case 7:
					checkx--;
					checky--;
					break;
				}
				if ((checkx < 8) && (checky < 8) && (checkx >= 0) && (checky >= 0)){
					if (theBoard.getPieceAtLocation(checkx,checky)==null ){
						possibleMoves.add(new Location(checkx, checky));
					}
					else{
					//The rook can still capture the piece if it is of the opposing color.
						if (this.getColor() != theBoard.getPieceAtLocation(checkx,checky).getColor()){
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
			checkx = x;
			checky = y;
			checkRows++;
		}//End of check
		return possibleMoves;
	}

}
