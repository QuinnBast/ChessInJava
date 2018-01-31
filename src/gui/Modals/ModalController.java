package gui.Modals;

import gui.Window.Window;

import javax.swing.*;

/**
 * Created by Quinn on 1/31/2018.
 */
public class ModalController {

    public ModalController(){

    }

    public void displayPromotionPanel(){
        Window.getLayers().add(new PromotionPanel(), JLayeredPane.MODAL_LAYER);
    }

}
