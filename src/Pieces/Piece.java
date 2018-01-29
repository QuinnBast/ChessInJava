package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;
import Engine.GameState;
import Engine.GameStates.Gamestates;

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
	if(color == "White"){
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
		if(ChessBoard.theState.getGameState() != Gamestates.INGAME) {
			return false;
		}

		if(GameState.getCurrentPlayer() != getColor()){
			return false;
		}

		if(this.canMoveTo(here) == 0){
			return false;
		}

		boolean capture = false;
		Piece capturedPiece = null;
		Location lastLocation = new Location(this.getLocation().getX(), this.getLocation().getY());

		//If you are trying to move to a valid location, check if there is an opponent there.
		if (ChessBoard.getPieceAtLocation(here.getX(), here.getY()) != null){
			//there is a piece there, lets remove it!
			capturedPiece = ChessBoard.getPieceAtLocation(here.getX(), here.getY());
			ChessBoard.takenPieces.add(ChessBoard.getPieceAtLocation(here.getX(), here.getY()));
			ChessBoard.board.remove(ChessBoard.getPieceAtLocation(here.getX(), here.getY()));
			capture = true;
		}
		//Is a pawn moving twice?
		//Check if the pawn moved twice for enPassant
		if(this instanceof Pawn){
			Pawn p = (Pawn)this;

			//If you are moving twice, set the flag for EnPassant
			if(Math.abs(this.location.getY() - here.getY()) == 2){
				//The pawn moved twice
				p.setMovedTwice(true);
			}

			//Check if you are capturing enPassant
			for(Location l : this.getPossibleMoves()){
				if(l.getY() == here.getY() && l.getX() == here.getX() && l.isEnPassant()){
					capture = true;
					if (GameState.getCurrentPlayer() == "White") {
						//Remove the pawn below the space for white
						capturedPiece = ChessBoard.getPieceAtLocation(here.getX(), here.getY()-1);
						ChessBoard.takenPieces.add(ChessBoard.getPieceAtLocation(here.getX(), here.getY()-1));
						ChessBoard.board.remove(ChessBoard.getPieceAtLocation(here.getX(), here.getY()-1));
						break;
					} else {
						//If black is moving then remove the piece above the required location.
						capturedPiece = ChessBoard.getPieceAtLocation(here.getX(), here.getY()+1);
						ChessBoard.takenPieces.add(ChessBoard.getPieceAtLocation(here.getX(), here.getY()+1));
						ChessBoard.board.remove(ChessBoard.getPieceAtLocation(here.getX(), here.getY()+1));
						break;
					}
				}
			}
		}

		//Do we need to move more than one piece in this move (castling/en Passant?)
		//Is a king castling??
		if (this.canMoveTo(here) == 2){
			//check the direction that the king is castling
			int xUp1 = here.getX() + 1;
			if (xUp1 == 2){
				//Castling left
				if(getColor() == "White") {
					ChessBoard.getPieceAtLocation(0,0).setLocation(3, 0);
					GameState.getHistory().addOOOCastle();
				}
				else {
					ChessBoard.getPieceAtLocation(0,7).setLocation(2, 7);
					GameState.getHistory().addOOOCastle();
				}
			} else if (xUp1 == 6) {
				//Castling left
				if (getColor() == "White") {
					ChessBoard.getPieceAtLocation(7, 0).setLocation(5, 0);
					GameState.getHistory().addOOCastle();
				} else {
					ChessBoard.getPieceAtLocation(7, 7).setLocation(4, 7);
					GameState.getHistory().addOOCastle();
				}
			}

			King theKing = (King) this;
			theKing.setHasMoved();
		}
		//move the piece and return
		setLocation(here.getX(), here.getY());
		ChessBoard.theState.switchPlayer();
		GameState.getHistory().addMove(this, lastLocation, capture);
		return true;
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
