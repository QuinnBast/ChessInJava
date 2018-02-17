package Engine.Movement.Moves;

import Engine.Board.ChessBoard;
import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;
import Engine.GameState;
import Engine.GameStates.Gamestates;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Capture extends Movement {

    private Piece capturedPiece;

    public Capture(Piece p, Location oldLocation, Location newLocation, Piece captured, boolean inCheck) {
        this.movedPiece = p;
        this.movedTo = newLocation;
        this.movedFrom = oldLocation;
        this.enemyInCheck = inCheck;
        this.moveString = determineMoveString();
        this.capturedPiece = captured;
    }

    public Piece getCapturedPiece(){
        return this.capturedPiece;
    }

    @Override
    protected String determineMoveString(){
        String prefix = "";

        //In case of enPassant
        if(this.getMovedPiece().getName().equals("Pawn")){
            prefix += getFileName(this.movedFrom.getX());
        } else {
            prefix += this.getMovedPiece().getName().charAt(0);
        }

        prefix += "x";
        prefix += getFileName(this.getMovedTo().getX());
        prefix += this.getMovedTo().getY() + 1;

        if(GameState.getGameState() == Gamestates.BLACK_WINS || GameState.getGameState() == Gamestates.WHITE_WINS){
            prefix += "#";
        } else if(enemyInCheck) {
            prefix += "+";
        }
        return prefix;
    }

    @Override
    public void undo() {
        this.movedPiece.setLocation(movedFrom.getX(), movedFrom.getY());
        ChessBoard.takenPieces.remove(capturedPiece);
        this.capturedPiece.setLocation(movedTo.getX(), movedTo.getY());
        ChessBoard.board.add(capturedPiece);
    }

    @Override
    public void redo() {
        this.movedPiece.setLocation(movedTo.getX(), movedTo.getY());
        ChessBoard.takenPieces.add(capturedPiece);
        ChessBoard.board.remove(capturedPiece);
    }
}
