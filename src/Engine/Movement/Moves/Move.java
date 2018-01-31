package Engine.Movement.Moves;

import Engine.GameState;
import Engine.GameStates.Gamestates;
import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Move {

    private Piece movedPiece;
    private Location movedTo;
    private Location movedFrom;
    private boolean enemyInCheck;
    private String moveString;

    public Move(Piece p, Location oldLocation, Location newLocation, boolean inCheck){
        this.movedPiece = p;
        this.movedTo = newLocation;
        this.movedFrom = oldLocation;
        this.enemyInCheck = inCheck;
        this.moveString = determineMoveString();
    }

    public Piece getMovedPiece(){
        return this.movedPiece;
    }

    public Location getMovedTo(){
        return this.movedTo;
    }

    public Location getMovedFrom(){
        return this.movedFrom;
    }

    public boolean getEnemyInCheck(){
        return this.enemyInCheck;
    }

    public String getMoveString(){
        return this.moveString;
    }

    private String determineMoveString(){
        String prefix = "";

        if(!this.getMovedPiece().getName().equals("Pawn") || this instanceof Capture){
            if(this.getMovedPiece().getName().equals("Pawn")){
                prefix += getFileName(this.movedFrom.getX());
            } else {
                prefix += this.getMovedPiece().getName().charAt(0);
            }
        }

        if(this instanceof Capture){
            prefix += "x";
        }

        prefix += getFileName(this.getMovedTo().getX());
        prefix += this.getMovedTo().getY() + 1;

        if(GameState.getGameState() == Gamestates.BLACK_WINS || GameState.getGameState() == Gamestates.WHITE_WINS){
            prefix += "#";
        } else if(enemyInCheck) {
            prefix += "+";
        }
        return prefix;
    }

    private String getFileName(int x){
        switch(x){
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
            default:
                return "";
        }
    }

}
