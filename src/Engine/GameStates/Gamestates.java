package Engine.GameStates;

import Engine.GameState;

/**
 * Created by Quinn on 1/28/2018.
 */
public enum Gamestates {
    INGAME ("inGame"),
    WHITE_WINS ("White wins"),
    BLACK_WINS ("Black wins"),
    STALEMATE ("Stalemate");

    private final String value;

    private Gamestates(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
