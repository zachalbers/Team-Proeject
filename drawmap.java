// imports required libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.ArrayList;

import java.lang.Object;
import java.util.*;

// Class for making the map   ++++++++++++
public class drawmap extends JPanel{

	// method that draws the buildings and its names  ++++++++++++++++
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.YELLOW);

		AllBuildings map1= new AllBuildings();
		Pathfinder path1 = new Pathfinder();


  // List<String> pathList2 = Collections.synchronizedList(new ArrayList<String>());
	// pathList2 = path1.pathList;



		for (String currentName : map1.buildingNames) {
				Building currentB = map1.buildings(currentName);

				int xcoord = (int)currentB.getX() * 10;
				int ycoord = 800 - ((int)currentB.getY() * 10);
				int length= (int)currentB.getLength();
				int width= (int)currentB.getWidth();

				String nameOfBuilding = currentB.getAbbreviation();

				//text for buildings
				g.setColor(Color.BLACK);
				g.drawString(nameOfBuilding, xcoord, ycoord);

				//draw pathway from cuurent to destination

				g.setColor(Color.RED);
				g.fillRect(xcoord,ycoord, length*7, width*7);
		}

				System.out.println(path1.pathList.size());


			for (int i = 0; i<(path1.pathList.size() - 1);i++ ) {
								int x1 = (int)map1.buildings(path1.pathList.get(i)).getX();
								int x2 = (int)map1.buildings(path1.pathList.get(i+1)).getX();
								int y1 = (int)map1.buildings(path1.pathList.get(i)).getY();
								int y2 = (int)map1.buildings(path1.pathList.get(i+1)).getY();
								g.drawLine(x1*10,(800-y1*10),x2*10,(800-y2*10));
								// System.out.println("getting");


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
