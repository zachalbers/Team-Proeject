import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.*;

// Class for making the map   ++++++++++++
public class MapWindow extends JPanel {




java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
java.util.List<String> settings = Collections.synchronizedList(new ArrayList<String>());

String[] bgColor; String[] bdColor; String[] pColor;


public MapWindow(java.util.List<String> pathList, HashMap<String,BuildingStructure> buildings, java.util.List<String> settings) {
		this.pathList = pathList;
		this.buildings = buildings;
		this.settings = settings;
		setSettings();

}



public void setSettings(){
	bdColor = settings.get(0).split(" ");
	pColor = settings.get(1).split(" ");
	bgColor = settings.get(2).split(" ");
}




public void drawbuildings(){
		JFrame Frame = new JFrame("Title");
		MapWindow shapes = new MapWindow(pathList, buildings, settings);
		Frame.add(shapes);
		Frame.setSize(1300, 800);
		Frame.setVisible(true);
}

// method that draws the buildings and its names  ++++++++++++++++
public void paintComponent(Graphics g){

		super.paintComponent(g);
		this.setBackground(new Color( Integer.parseInt(bgColor[0]), Integer.parseInt(bgColor[1]), Integer.parseInt(bgColor[2]) ));





		Graphics2D g2 = (Graphics2D) g;

		// g2.rotate(Math.toRadians(-10));


		// Draws a line between all the buildings on the path list.
		for (int i = 0; i<(pathList.size() - 1); i++ ) {
				int x1 = (int)buildings.get(pathList.get(i)).getX() + buildings.get(pathList.get(i)).getLength()/2;
				int x2 = (int)buildings.get(pathList.get(i+1)).getX() + buildings.get(pathList.get(i+1)).getLength()/2;
				int y1 = (int)buildings.get(pathList.get(i)).getY() - buildings.get(pathList.get(i)).getHeight()/2;
				int y2 = (int)buildings.get(pathList.get(i+1)).getY() - buildings.get(pathList.get(i+1)).getHeight()/2;

				g2.setStroke(new BasicStroke(6));
				g2.setColor(new Color( Integer.parseInt(pColor[0]), Integer.parseInt(pColor[1]), Integer.parseInt(pColor[2]) ));
				g2.drawLine(x1,(800-y1),x2,(800-y2));
		}



		// Draws all buildings
		for (String currentName : buildings.keySet()) {
				BuildingStructure currentB = buildings.get(currentName);

				int xcoord = (int)currentB.getX();
				int ycoord = 800 - ((int)currentB.getY());
				int length= (int)currentB.getLength();
				int height= (int)currentB.getHeight();

				String nameOfBuilding = currentB.getAbbreviation();

				//text for buildings
				g2.setColor(Color.BLACK);
				g2.drawString(nameOfBuilding, xcoord, ycoord);



				//draw pathway from cuurent to destination


				g2.setColor(new Color( Integer.parseInt(bdColor[0]), Integer.parseInt(bdColor[1]), Integer.parseInt(bdColor[2]) ));
				g2.fillRect(xcoord,ycoord, length, height);
		}

		// Draws the outline of the buildings
		for (String currentName : pathList) {
				BuildingStructure currentB = buildings.get(currentName);

				int xcoord = (int)currentB.getX();
				int ycoord = 800 - ((int)currentB.getY());
				int length= (int)currentB.getLength();
				int height= (int)currentB.getHeight();

				g2.setColor(Color.RED);
			  g2.setStroke(new BasicStroke(2));
				g2.drawLine(xcoord, ycoord, xcoord, ycoord + height);
				g2.drawLine(xcoord, ycoord, xcoord + length, ycoord);
				g2.drawLine(xcoord + length, ycoord, xcoord + length, ycoord + height);
				g2.drawLine(xcoord, ycoord + height, xcoord + length, ycoord + height);

		}




// COlor for everythiNg = new Color(193, 110, 110)




}



}
