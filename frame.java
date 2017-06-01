// imports required modules 
import javax.swing.JFrame;

// Class for making Jframe and displaying the buildings and building names on the jframe
public class frame {
	
	//
	public void drawbuildings(){
		JFrame frame = new JFrame("Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawmap shapes = new drawmap();
		frame.add(shapes);
		frame.setSize(400, 250);
		frame.setVisible(true);
	}




}
