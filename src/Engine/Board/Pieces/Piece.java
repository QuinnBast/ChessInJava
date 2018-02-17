package Engine.Board.Pieces;

import java.util.ArrayList;

import Engine.Board.ChessBoard;
import Engine.GameState;
import Engine.GameStates.Gamestates;
import Engine.Movement.Moves.Capture;
import Engine.Movement.Moves.Castle;
import Engine.Movement.Moves.Move;

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

		boolean capture = false;
		boolean castle = false;
		Piece capturedPiece = null;
		Location lastLocation = new Location(this.getLocation().getX(), this.getLocation().getY());

		if(this instanceof King) {
			ArrayList<Location> moves = this.getPossibleMoves();
			for(Location l : moves){
				if(here.getX() == l.getX() && here.getY() == l.getY()){
					//All of the king's moves get checked beforehand thus all king moves are valid. Just need to check if we are castling.
					//Do we need to move more than one piece in this move (castling/en Passant?)
					//Is a king castling??
					if (here.isCastling()){
						castle = true;
						//check the direction that the king is castling
						if (here.getX() == 2){
							//Castling left
							GameState.getHistory().addMove(new Castle(this, this.getLocation(), here, true));
							if(getColor() == "White") {
								ChessBoard.getPieceAtLocation(0,0).setLocation(3, 0);
							}
							else {
								ChessBoard.getPieceAtLocation(0,7).setLocation(3, 7);
							}
						} else if (here.getX() == 6) {
							//Castling right
							GameState.getHistory().addMove(new Castle(this, this.getLocation(), here, false));
							if (getColor() == "White") {
								ChessBoard.getPieceAtLocation(7, 0).setLocation(5, 0);
							} else {
								ChessBoard.getPieceAtLocation(7, 7).setLocation(5, 7);
							}
						}

						King theKing = (King) this;
						theKing.setHasMoved();
					}
					//move the piece and return
					setLocation(here.getX(), here.getY());
					ChessBoard.theState.switchPlayer();
					if(!castle) {
						if (capture) {
							GameState.getHistory().addMove(new Capture(this, lastLocation, here, capturedPiece, GameState.getPlayerInCheck(GameState.getCurrentPlayer())));
						} else {
							GameState.getHistory().addMove(new Move(this, lastLocation, here,GameState.getPlayerInCheck(GameState.getCurrentPlayer())));
						}
					}
					return true;
				}
			}
		}

		if(ChessBoard.theState.getGameState() != Gamestates.INGAME) {
			return false;
		}

		if(GameState.getCurrentPlayer() != getColor()){
			return false;
		}

		if(this.canMoveTo(here) == 0){
			return false;
		}

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
		//move the piece and return
		setLocation(here.getX(), here.getY());
		if(!castle) {
			if (capture) {
				GameState.getHistory().addMove(new Capture(this, lastLocation, here, capturedPiece, GameState.getPlayerInCheck(GameState.getCurrentPlayer())));
			} else {
				GameState.getHistory().addMove(new Move(this, lastLocation, here,GameState.getPlayerInCheck(GameState.getCurrentPlayer())));
			}
		}
		ChessBoard.theState.switchPlayer();
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

				//Check if the current player is in check when moving the piece
				if(GameState.getPlayerInCheck(GameState.getCurrentPlayer())){
					//Check if after moving the piece the player is no longer in check
					Location l = new Location(this.getLocation().getX(), this.getLocation().getY());

					Piece capture = null;
					if(ChessBoard.getPieceAtLocation(here.getX(), here.getY()) != null){
						//there is a piece that needs to be captured
						capture = ChessBoard.getPieceAtLocation(here.getX(), here.getY());
						ChessBoard.getBoard().remove(capture);
					}

					this.setLocation(here.getX(), here.getY());

					//If the player is still in check the move is not valid.
					if(GameState.getPlayerInCheck(GameState.getCurrentPlayer())){
						this.setLocation(l.getX(), l.getY());
						if(capture != null){
							ChessBoard.getBoard().add(capture);
						}
						return 0;
					} else {
						this.setLocation(l.getX(), l.getY());
						if(capture != null){
							ChessBoard.getBoard().add(capture);
						}
						return 1;
					}
				}

				//Check if the player is trying to move a piece pinned to the king
				Location l = new Location(this.getLocation().getX(), this.getLocation().getY());
				Piece capture = null;
				if(ChessBoard.getPieceAtLocation(l.getX(), l.getY()) != null){
					//there is a piece that needs to be captured
					capture = ChessBoard.getPieceAtLocation(l.getX(), l.getY());
					ChessBoard.getBoard().remove(capture);
				}
				this.setLocation(here.getX(), here.getY());
				if(GameState.getPlayerInCheck(GameState.getCurrentPlayer())){
					//If the player is trying to move a pinned piece, it is invalid.
					this.setLocation(l.getX(), l.getY());
					if(capture != null){
						ChessBoard.getBoard().add(capture);
					}
					return 0;
				}
				this.setLocation(l.getX(), l.getY());
				if(capture != null){
					ChessBoard.getBoard().add(capture);
				}
				return 1;
			}
		}
		return 0;
	}
}
