import javax.swing.JFrame;
import java.awt.Rectangle; //abstract window toolkit library

public class userGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame(); //create a JFrame instance
		window.setSize(640, 480); //set the size of the window
		window.setTitle("This is a JFrame"); //Creates the window's title
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the window is closed, end the program
		window.setVisible(true); //make the window appear
	
		DrawingFactory DrawFactory = new DrawingFactory();
		window.add(DrawFactory);
	}

}
