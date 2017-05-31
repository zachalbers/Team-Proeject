
import javax.swing.JFrame;

public class frame {

	public void drawbuildings(){
		JFrame frame = new JFrame("Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawmap shapes = new drawmap();
		frame.add(shapes);
		frame.setSize(400, 250);
		frame.setVisible(true);
	}


	// public void run() {
	// 	frame frame1 = new frame();
	// 	frame1.drawbuildings();
	// }
	//




}
