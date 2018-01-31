package gui.Window;

import gui.Menu.MenuGui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quinn on 1/30/2018.
 */
public class Window extends JFrame {

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800,800);
    private static WindowLayers layers = new WindowLayers();

    public Window(){
        this.setSize(OUTER_FRAME_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(new MenuGui());
        this.setTitle("Chess");
        this.add(layers);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/WhitePawn.png")).getImage());
        this.setVisible(true);
    }

    public static JLayeredPane getLayers(){
        return layers;
    }

    public static void updateWindow(){
        if(layers != null) {
            layers.updateLayers();
        }
    }

    public void updateMe(){
        layers.updateLayers();
    }

}
