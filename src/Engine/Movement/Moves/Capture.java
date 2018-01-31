package Engine.Movement.Moves;

import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Capture extends Move {

    private Piece capturedPiece;

    public Capture(Piece p, Location oldLocation, Location newLocation, Piece captured, boolean inCheck) {
        super(p, oldLocation, newLocation, inCheck);
        this.capturedPiece = captured;
    }

    public Piece getCapturedPiece(){
        return this.capturedPiece;
    }
}
