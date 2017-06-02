import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.*;

// Class for making the map   ++++++++++++
public class drawmap extends JPanel{



	java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());


	public drawmap(java.util.List<String> pathList) {
	this.pathList = pathList;
	}

	// method that draws the buildings and its names  ++++++++++++++++
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.YELLOW);

		AllBuildings map1= new AllBuildings();





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

				// Color Puce = new Color(193, 110, 100);

				g.setColor(new Color(193, 110, 110));
				g.fillRect(xcoord,ycoord, length*7, width*7);
		}




				for (int i = 0; i<(pathList.size() - 1);i++ ) {
									int x1 = (int)map1.buildings(pathList.get(i)).getX();
									int x2 = (int)map1.buildings(pathList.get(i+1)).getX();
									int y1 = (int)map1.buildings(pathList.get(i)).getY();
									int y2 = (int)map1.buildings(pathList.get(i+1)).getY();
									g.drawLine(x1*10,(800-y1*10),x2*10,(800-y2*10));



				}





	}













}
