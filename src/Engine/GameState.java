package Engine;

import Pieces.King;
import Pieces.Location;
import Pieces.Pawn;
import Pieces.Piece;

public class GameState {
	public static String currentMove;
	private static String gameState;
	private boolean currentPlayerIsInCheck = false; 
	private int whiteWins = 0;
	private int blackWins = 0;
	
	public GameState(){
		this.currentMove = "White";
		this.gameState = "inGame";
	}
	
	public static String getCurrentPlayer(){
		return currentMove;
	}
	
	public void setCurrentPlayer(String player){
		this.currentMove = player;
	}
	
	public void switchPlayer(){
		//check if the game is over
		if(ChessBoard.getKing(currentMove).isInCheck()){
			this.currentMove = (this.currentMove == "White") ? "Black" : "White";
			gameState = currentMove + " Wins";
			if(currentMove == "White"){this.whiteWins++;}else{blackWins++;}
			System.out.println(gameState);
			return;
		}
		//switch players
		this.currentMove = (this.currentMove == "White") ? "Black" : "White";

		//Reset pawns tagged for EnPassant for current Player
		for(Piece p : ChessBoard.board){
			if(p.getColor() == currentMove && p instanceof Pawn && (((Pawn) p).getMovedTwice() == true)){
				((Pawn) p).setMovedTwice(false);
			}
		}
		
		if (ChessBoard.getPlayersPossibleMoves(currentMove) == null && ChessBoard.getKing(currentMove).isInCheck() == false){
			gameState = "Stalemate";
			System.out.println(gameState);
			return;
		}
		
		if(ChessBoard.getKing(currentMove).isInCheck()){
			setCurrentPlayerInCheck(true);
			for(Piece piece : ChessBoard.board){
				if(piece.getColor() == currentMove){
					//For each of the current player's pieces,
					//Try to see if the piece can prevent the check.

					//Save the initial location of the piece.
					Location initialLocation = new Location(piece.getLocation().getX(), piece.getLocation().getY());

					//For all possible moves for that piece, attempt to move that piece.
					for(Location possibleMove : piece.getPossibleMoves()){
						//Attempt to move the piece.
						piece.setLocation(possibleMove.getX(), possibleMove.getY());
						//If the king isn't in check after the move, it is not checkmate.
						if(!ChessBoard.getKing(currentMove).isInCheck()){
							//Reset the piece's location.
							piece.setLocation(initialLocation.getX(), initialLocation.getY());
							System.out.println("You are in check!");
							setCurrentPlayerInCheck(true);
							return;
						}
					}
					//Reset the piece's location.
					piece.setLocation(initialLocation.getX(), initialLocation.getY());
				}
			}
			//If its not possible to avoid check, Checkmate.
			System.out.println("Checkmate");
			gameState = (currentMove == "White" ? "Black" : "White") + " Wins";
			if(currentMove == "White"){this.blackWins++;}else{whiteWins++;}
			return;
		} else {setCurrentPlayerInCheck(false);}
	}

	public boolean getCurrentPlayerInCheck() {
		return currentPlayerIsInCheck;
	}

	public void setCurrentPlayerInCheck(boolean currentPlayerIsInCheck) {
		this.currentPlayerIsInCheck = currentPlayerIsInCheck;
	}
	
	public String getGameState(){
		return this.gameState;
	}
	
	public static void setGameState(String state){
		gameState = state;
	}
	
	public int getWhiteWins(){
		return whiteWins;
	}
	
	public int getBlackWins(){
		return blackWins;
	}
}
