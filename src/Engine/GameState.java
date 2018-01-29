package Engine;

import Engine.GameStates.Gamestates;
import Pieces.King;
import Pieces.Location;
import Pieces.Pawn;
import Pieces.Piece;

public class GameState {
	public static String currentMove;
	private static Gamestates gameState;
	private static boolean currentPlayerIsInCheck = false;
	private static MoveHistory history = new MoveHistory();
	private int whiteWins = 0;
	private int blackWins = 0;
	
	public GameState(){
		this.currentMove = "White";
		this.gameState = Gamestates.INGAME;
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
			if(currentMove == "White"){
				gameState = Gamestates.WHITE_WINS;
			} else {
				gameState = Gamestates.BLACK_WINS;
			}

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
			gameState = Gamestates.STALEMATE;
			System.out.println(gameState);
			return;
		}

		//Check if checkmate
		if(ChessBoard.getKing(currentMove).isInCheck()){
			setCurrentPlayerInCheck(true);
			for (Piece piece : ChessBoard.getPlayersPieces(this.currentMove)) {
				//For each of the current player's pieces,
				//Try to see if the piece can prevent the check.

				//Save the initial location of the piece.
				Location initialLocation = new Location(piece.getLocation().getX(), piece.getLocation().getY());

				//For all possible moves for that piece, attempt to move that piece.
				for (Location possibleMove : piece.getPossibleMoves()) {
					//Attempt to move the piece.
					piece.setLocation(possibleMove.getX(), possibleMove.getY());
					//If the king isn't in check after the move, it is not checkmate.
					if (!ChessBoard.getKing(currentMove).isInCheck()) {
						//Reset the piece's location.
						piece.setLocation(initialLocation.getX(), initialLocation.getY());
						System.out.println("You are in check!");
						return;
					}
				}
				//Reset the piece's location.
				piece.setLocation(initialLocation.getX(), initialLocation.getY());
			}
			//If its not possible to avoid check, Checkmate.
			System.out.println("Checkmate");
			gameState = (currentMove == "White" ? Gamestates.BLACK_WINS : Gamestates.WHITE_WINS);
			if (currentMove == "White") {
				this.blackWins++;
			} else {
				whiteWins++;
			}
			return;
		} else {setCurrentPlayerInCheck(false);}
	}

	public static boolean getCurrentPlayerInCheck() {
		return currentPlayerIsInCheck;
	}

	public void setCurrentPlayerInCheck(boolean currentPlayerIsInCheck) {
		this.currentPlayerIsInCheck = currentPlayerIsInCheck;
	}
	
	public static Gamestates getGameState(){
		return gameState;
	}
	
	public void setGameState(Gamestates state){
		gameState = state;
	}
	
	public int getWhiteWins(){
		return whiteWins;
	}
	
	public int getBlackWins(){
		return blackWins;
	}

	public static MoveHistory getHistory(){
		return history;
	}

}
