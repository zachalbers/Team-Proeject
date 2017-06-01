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

		AllBuildings map1= new AllBuildings();



		for (String currentName : map1.buildingNames) {
				Building currentB = map1.buildings(currentName);

				int xcoord = (int)currentB.getX() * 10;
				int ycoord = 800 - ((int)currentB.getY() * 10);

				String nameOfBuilding = currentB.getBuildingName();

				//
				g.setColor(Color.RED);
				g.drawString(nameOfBuilding, xcoord, ycoord);



				g.setColor(Color.BLUE);
				g.fillRect(xcoord,ycoord, 20, 20);


		}


    // Science B
		// g.setColor(Color.BLUE);
		// g.fillRect(map1.getX(),map1.getY(), 3, 3);
		//
		// g.setColor(Color.BLACK);
		// g.fillRect(1005, 140, 100, 30);
		//
		// g.setColor(Color.RED);
		// g.drawString("RECTANGLES", 25, 120);

	}













}
