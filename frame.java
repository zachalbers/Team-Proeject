// imports required modules
import javax.swing.JFrame;
import java.util.*;

// Class for making Jframe and displaying the buildings and building names on the jframe
public class Frame {

	java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());


	public Frame(java.util.List<String> pathList) {
		this.pathList = pathList;
	}



	public void drawbuildings(){
		JFrame Frame = new JFrame("Title");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawmap shapes = new drawmap(pathList);
		Frame.add(shapes);
		Frame.setSize(1300, 800);
		Frame.setVisible(true);
	}




}
