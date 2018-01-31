package Engine.Movement.Moves;

import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Castle extends Move {

    private boolean OOO;

    public Castle(Piece p, Location oldLocation, Location newLocation, boolean OOO) {
            super(p, oldLocation, newLocation, false);
            this.OOO = OOO;
    }

    public boolean isOOO(){
        return this.OOO;
    }


}
