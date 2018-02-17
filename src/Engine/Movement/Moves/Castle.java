package Engine.Movement.Moves;

import Engine.Board.ChessBoard;
import Engine.Board.Pieces.Location;
import Engine.Board.Pieces.Piece;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Castle extends Movement {

    private boolean OOO;

    public Castle(Piece p, Location oldLocation, Location newLocation, boolean OOO) {
        this.movedPiece = p;
        this.movedTo = newLocation;
        this.movedFrom = oldLocation;
        this.enemyInCheck = false;
        this.moveString = determineMoveString();
        this.OOO = OOO;
    }

    public boolean isOOO(){
        return this.OOO;
    }


    @Override
    protected String determineMoveString() {
        return isOOO() ? "O-O-O" : "O-O";
    }

    @Override
    public void undo() {
        if(movedPiece.getColor() == "White"){
            movedPiece.setLocation(4, 0);

            //Get the rook that was castled with and set it back
            if(isOOO()){
                ChessBoard.getPieceAtLocation(3, 0).setLocation(0, 0);
            } else {
                ChessBoard.getPieceAtLocation(5, 0).setLocation(7, 0);
            }
        } else {
            movedPiece.setLocation(4, 7);
            //Get the rook that was castled with and set it back
            if(isOOO()){
                ChessBoard.getPieceAtLocation(3, 7).setLocation(0, 7);
            } else {
                ChessBoard.getPieceAtLocation(5, 7).setLocation(7, 7);
            }
        }
    }

    @Override
    public void redo() {
        if(movedPiece.getColor() == "White"){
            //Get the rook that was castled with and set it back
            if(isOOO()){
                ChessBoard.getPieceAtLocation(0, 0).setLocation(3, 0);
                movedPiece.setLocation(2, 0);
            } else {
                ChessBoard.getPieceAtLocation(7, 0).setLocation(5, 0);
                movedPiece.setLocation(6, 0);
            }
        } else {
            //Get the rook that was castled with and set it back
            if(isOOO()){
                ChessBoard.getPieceAtLocation(0, 7).setLocation(3, 7);
                movedPiece.setLocation(2, 7);
            } else {
                ChessBoard.getPieceAtLocation(7, 7).setLocation(5, 7);
                movedPiece.setLocation(6, 7);
            }
        }
    }
}
