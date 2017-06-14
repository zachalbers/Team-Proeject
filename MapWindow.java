import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.*;

// Class for making the map   ++++++++++++
public class MapWindow extends JPanel {



java.util.HashMap<String, ImageIcon> imageList = new HashMap<String, ImageIcon>();




java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
java.util.List<String[]> settings = Collections.synchronizedList(new ArrayList<String[]>());
Color backgroundColor; Color pathColor; Color buildingColor;
Boolean willDraw;





public MapWindow(java.util.List<String> pathList, HashMap<String,BuildingStructure> buildings, java.util.List<String[]> settings) {
		this.pathList = pathList;
		this.buildings = buildings;
		this.settings = settings;
		setSettings();


}



public void setSettings(){

	String[] bdColor = settings.get(0);
	String[] pColor = settings.get(1);
	String[] bgColor = settings.get(2);
	willDraw = Boolean.valueOf(settings.get(3)[0]);


	buildingColor = new Color( Integer.parseInt(bdColor[0]), Integer.parseInt(bdColor[1]), Integer.parseInt(bdColor[2]) );
	pathColor = new Color( Integer.parseInt(pColor[0]), Integer.parseInt(pColor[1]), Integer.parseInt(pColor[2]) );
	backgroundColor = new Color( Integer.parseInt(bgColor[0]), Integer.parseInt(bgColor[1]), Integer.parseInt(bgColor[2]) );

	settings.remove(3);
	settings.remove(2);
	settings.remove(1);
	settings.remove(0);
}


// method that draws the buildings and its names  ++++++++++++++++
public void paintComponent(Graphics g){

		super.paintComponent(g);

		g.setColor(backgroundColor);
		g.fillRect(0, 0, 1300, 800);


		// Graphics2D g2 = (Graphics2D) g;



		System.out.println("part 3");

		// Draws a line between all the buildings on the path list.
		drawPath(g);

		// // Draws all buildings
		drawAllBuildings(g);


		// Draws the outline of the buildings
		drawOutline(g);




		if (willDraw) {
				drawMapLegend(g);
		}


		}







public void drawAllBuildings(Graphics g2) {
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

				g2.setColor(buildingColor);
				g2.fillRect(xcoord,ycoord, length, height);
	}
}

public void drawOutline(Graphics g2) {
		for (String currentName : pathList) {
				BuildingStructure currentB = buildings.get(currentName);

				int xcoord = (int)currentB.getX();
				int ycoord = 800 - ((int)currentB.getY());
				int length= (int)currentB.getLength();
				int height= (int)currentB.getHeight();

				g2.setColor(Color.RED);
				// g2.setStroke(new BasicStroke(2));
				g2.drawLine(xcoord, ycoord, xcoord, ycoord + height);
				g2.drawLine(xcoord, ycoord, xcoord + length, ycoord);
				g2.drawLine(xcoord + length, ycoord, xcoord + length, ycoord + height);
				g2.drawLine(xcoord, ycoord + height, xcoord + length, ycoord + height);
		}
}

public void drawPath(Graphics g2) {

	for (int i = 0; i<(pathList.size() - 1); i++ ) {
			int x1 = (int)buildings.get(pathList.get(i)).getX() + buildings.get(pathList.get(i)).getLength()/2;
			int x2 = (int)buildings.get(pathList.get(i+1)).getX() + buildings.get(pathList.get(i+1)).getLength()/2;
			int y1 = (int)buildings.get(pathList.get(i)).getY() - buildings.get(pathList.get(i)).getHeight()/2;
			int y2 = (int)buildings.get(pathList.get(i+1)).getY() - buildings.get(pathList.get(i+1)).getHeight()/2;

			// g2.setStroke(new BasicStroke(6));
			g2.setColor(pathColor);
			g2.drawLine(x1,(800-y1),x2,(800-y2));
	}

}


public void drawMapLegend(Graphics g2) {

	int LX = Integer.parseInt(settings.get(0)[0]);
	int LY = Integer.parseInt(settings.get(0)[1]);

	g2.setColor(Color.WHITE);
	g2.fillRect(LX, LY, Integer.parseInt(settings.get(0)[2]), Integer.parseInt(settings.get(0)[3]));
	settings.remove(0);



	g2.setColor(pathColor);
	g2.fillRect(LX + 100, LY + 11, 10, 10);


	g2.setColor(Color.BLACK);
	g2.drawString("Color of Path:", LX + 10, LY + 20);
	g2.drawString("Your Current Location is: " + pathList.get(0), LX + 10, LY + 40);
	g2.drawString("Your Destination is: " + pathList.get(pathList.size() - 1), LX + 10, LY + 60);








	for (String[] iconData: settings) {

		imageList.put(iconData[0], new ImageIcon("./Icon-Files/" + iconData[0]) );
		imageList.get(iconData[0]).paintIcon(this, g2, Integer.parseInt(iconData[1]), 800 - Integer.parseInt(iconData[2]) );




	}
}





}
