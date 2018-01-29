package Engine;

import Engine.GameStates.Gamestates;
import Pieces.Location;
import Pieces.Pawn;
import Pieces.Piece;

import java.util.ArrayList;

/**
 * Created by Quinn on 1/28/2018.
 */
public class MoveHistory {

    private ArrayList<String> moves = new ArrayList<String>();

    public MoveHistory(){

    }

    public String getMove(int i){
        return this.moves.get(i);
    }

    public void addMove(Piece piece, Location LastLocation, boolean capture){
        String prefix = "";
        if(!piece.getName().equals("Pawn") || capture){
            if(piece.getName().equals("Pawn")){
                prefix += getFile(LastLocation.getX());
            } else {
                prefix += piece.getName().charAt(0);
            }
        }
        if(capture){
            prefix += "x";
        }
        prefix += getFile(piece.getLocation().getX());
        prefix += piece.getLocation().getY() + 1;

        if(GameState.getCurrentPlayerInCheck()){
            prefix += "+";
        }

        this.moves.add(prefix);
    }

    public String getLastMove(){
        return this.moves.get(this.moves.size() - 1);
    }

    public void addOOCastle(){
        this.moves.add("O-O");
    }

    public void addOOOCastle(){
        this.moves.add("O-O-O");
    }

    public String printMoves(){
        String moveHistory = "";
        for(int i=0; i<=moves.size() - 1; i++){
            if(i == 0){
                moveHistory += "1. ";
            } else if(i % 2 == 0){
                moveHistory += "" + ((i / 2) + 1) + ". ";
            }

            moveHistory += this.moves.get(i) + " ";
        }
        return moveHistory;
    }

    private String getFile(int x){
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

    public void addInCheck(){
        moves.set(moves.size() - 1, moves.get(moves.size() - 1) + "+");
    }

    public void checkmate(){
        moves.set(moves.size() - 1, moves.get(moves.size() - 1) + "#");
    }
}
