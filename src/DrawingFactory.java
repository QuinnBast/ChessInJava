import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class DrawingFactory extends JComponent {
	//extend the JComponent class
	//inheriting methods from it
	
	//any change to a JFrame causes this function to be ran
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g; //cast g to a graphics2D class
		//takes our original graphics and makes it a 2D graphic for better manipulation
	
		g2.draw(new Rectangle(10, 10, 610, 450));
		//draw a rectangle!
		
	}
	
	
}
