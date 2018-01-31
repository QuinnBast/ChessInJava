package Engine.Movement.MovementControls;

import Engine.Movement.Moves.Move;

import java.util.ArrayList;

/**
 * Created by Quinn on 1/28/2018.
 */
public class MoveHistory {

    private ArrayList<Move> moves = new ArrayList<Move>();

    public MoveHistory(){

    }

    public Move getMove(int i){
        return this.moves.get(i);
    }

    public void addMove(Move m){
        moves.add(m);
    }

    public Move getLastMove(){
        return this.moves.get(this.moves.size() - 1);
    }

    public String printMoves(){
        String moveHistory = "";
        for(int i = (moves.size() > 16) ? moves.size() - 16 : 0; i<=moves.size() - 1; i++){
            if(i == 0){
                moveHistory += "1. ";
            } else if(i % 2 == 0){
                moveHistory += "" + ((i / 2) + 1) + ". ";
            }

            moveHistory += moves.get(i).getMoveString() + " ";
        }
        return moveHistory;
    }

    public void reset(){
        this.moves = new ArrayList<Move>();
    }


}
