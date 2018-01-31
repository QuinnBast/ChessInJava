package gui;

import Engine.GameState;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/26/2018.
 */
public class PromotionPanel extends JPanel {

    public static boolean updated;
    int locationx = 0;
    int locationy = 0;

    PromotionPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;


        JLabel label = new JLabel("Promote", SwingConstants.CENTER);

        Font labelFont = label.getFont();

        // Set the label's font size to the newly determined size.
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 24));

        c.gridwidth = 2;    //Make this take up 2 wide
        c.gridx = 0;        //set position 0
        c.gridy = 0;        //set position 0
        this.add(label, c);

        //Create 5 components into the gridBaglayout.
        PromotePieceImage promoteKnight = new PromotePieceImage(GameState.getCurrentPlayer() + " Knight", this);
        c.weightx = 0.5;    //Take up half the horizontal space.
        c.gridwidth = 1;    //Reset the grid width
        c.gridx = 0;        //Set the x to be 0 (far left)
        c.gridy = 1;        //Set y to be 1 (second row)
        this.add(promoteKnight, c);

        PromotePieceImage promoteBishop = new PromotePieceImage(GameState.getCurrentPlayer() + " Bishop", this);
        c.gridx = 1;
        c.gridy = 1;
        this.add(promoteBishop, c);

        PromotePieceImage promoteRook = new PromotePieceImage(GameState.getCurrentPlayer() + " Rook", this);
        c.gridx = 0;
        c.gridy = 2;
        this.add(promoteRook, c);

        PromotePieceImage promoteQueen = new PromotePieceImage(GameState.getCurrentPlayer() + " Queen", this);
        c.gridx = 1;
        c.gridy = 2;
        this.add(promoteQueen, c);

        this.setVisible(false);
        this.setBounds(this.locationx, this.locationx, 300, 300);
        this.setBackground(Color.GRAY);
        this.validate();
    }

    public void setLocation(int x, int y){
        this.locationx = x;
        this.locationy = y;
        this.setBounds(x, y, 300, 300);
    }
}
