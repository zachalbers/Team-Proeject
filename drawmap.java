// imports required libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Class for making the map   ++++++++++++
public class drawmap extends JPanel{

	// method that draws the buildings and its names  ++++++++++++++++
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 30);

		g.setColor(Color.BLACK);
		g.fillRect(25, 65, 100, 30);

		g.setColor(Color.RED);
		g.drawString("RECTANGLES", 25, 120);

	}













}
