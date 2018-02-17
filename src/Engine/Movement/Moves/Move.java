package Engine.Movement.Moves;

import Engine.GameState;
import Engine.GameStates.Gamestates;
import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Move extends Movement {

    public Move(Piece p, Location oldLocation, Location newLocation, boolean inCheck){
        this.movedPiece = p;
        this.movedTo = newLocation;
        this.movedFrom = oldLocation;
        this.enemyInCheck = inCheck;
        this.moveString = determineMoveString();
    }

    protected String determineMoveString(){
        String prefix = "";

        if(this.getMovedPiece().getName().equals("Pawn")){
            prefix += getFileName(this.movedFrom.getX());
        } else {
            prefix += this.getMovedPiece().getName().charAt(0);
            prefix += getFileName(this.getMovedTo().getX());
        }

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
        movedPiece.setLocation(movedFrom.getX(), movedFrom.getY());
    }


    @Override
    public void redo() {
        movedPiece.setLocation(movedTo.getX(), movedTo.getY());
    }

}
