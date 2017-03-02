package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public abstract class Piece {
	private String color;
	private String name;
	private Location location;
	private String imagePath;
	
	public Piece(){
		
	}
	
	public Piece(String color, String name, int posx, int posy){
	this.color = color;	
	this.name = name;
	this.location = new Location(posx, posy);
	if(color == "white"){
		this.imagePath = "/Images/White"+name+".png";
	}
	else
		this.imagePath = "/Images/Black"+name+".png";
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getImagePath(){
		return this.imagePath;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setLocation(int posx, int posy){
		this.location.setX(posx);
		this.location.setY(posy);
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	public boolean move(Location here){
		if(ChessBoard.theState.getGameState() == "inGame"){
			if (ChessBoard.theState.getCurrentPlayer() == getColor()){
				if (this.canMoveTo(here) == 1 || this.canMoveTo(here) == 2){
					//If you are trying to move to a valid location, check if there is an opponent there.
					if (ChessBoard.getPieceAtLocation(here.getX(), here.getY()) != null){
						//there is a piece there, lets remove it!
						ChessBoard.board.remove(ChessBoard.getPieceAtLocation(here.getX(), here.getY()));
					}
					//move the piece and return
					setLocation(here.getX(), here.getY());
					
					//Do we need to move more than one piece in this move (castling/en Passant?)
					//Is a king castling??
					if (this.canMoveTo(here) == 2){
						//check the direction that the king is castling
						int xUp1 = here.getX() + 1;
						if (xUp1 == 3){
							//the King is white castling left
							ChessBoard.getPieceAtLocation(0,0).setLocation(3, 0);
						} else if (xUp1 == 7){
							//the king is white castling right
							ChessBoard.getPieceAtLocation(7,0).setLocation(5, 0);
						} else if (xUp1 == 6){
							//The king is black castling (right to white) left
							ChessBoard.getPieceAtLocation(7,7).setLocation(4, 7);
						} else if (xUp1 == 2){
							//the king is black castling (left to white) right
							ChessBoard.getPieceAtLocation(0,7).setLocation(2, 7);
						}
						King theKing = (King) this;
						theKing.setHasMoved();
					}
				ChessBoard.theState.switchPlayer();
				return true;
				}
			}
		}
		return false;
		}		
	
	public abstract ArrayList<Location> getPossibleMoves();
	
	
	/*
	 * Takes in a location and determines if a piece can move to that location.
	 * Prevents looping in every single function
	 * 
	 * Return:
	 * 	0 - Cannot move to that location
	 *  1 - Can normally move to that location
	 *  2 - King Can move to that location by Castling
	 */
	public int canMoveTo(Location here){
		ArrayList<Location> moves = this.getPossibleMoves();
		for(int i=0; i<moves.size(); i++){
			if (here.getX() == moves.get(i).getX() && here.getY() == moves.get(i).getY()){
				if (here.isCastling()){
					return 2;
				}
				return 1;
			}
		}
		return 0;
	}
}
