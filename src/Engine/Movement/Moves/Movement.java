package Engine.Movement.Moves;

import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 2/16/2018.
 */
public abstract class Movement {

    protected Piece movedPiece;
    protected Location movedTo;
    protected Location movedFrom;
    protected boolean enemyInCheck;
    protected String moveString;

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

    protected abstract String determineMoveString();

    protected String getFileName(int x){
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

    public abstract void undo();

    public abstract void redo();

}
