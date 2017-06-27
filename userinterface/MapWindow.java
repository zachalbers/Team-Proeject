/*
This class creates a new window and draws all the buildings in the specified txt file along with the user's chosen path.
If the txt file has a map legend enabled, then that will be drawn as well.
*/



package unimap.userinterface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.*;
import java.io.*;
import unimap.programlogic.*;


public class MapWindow extends JPanel {


java.util.HashMap<String, ImageIcon> imageList = new HashMap<String, ImageIcon>();
java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
java.util.List<String[]> settings = Collections.synchronizedList(new ArrayList<String[]>());
private Color backgroundColor, pathColor, buildingColor;
private Boolean willDraw;
private String time;


public MapWindow(java.util.List<String> pathList, HashMap<String,BuildingStructure> buildings, java.util.List<String[]> settings,String time) {
	this.pathList = pathList;
	this.buildings = buildings;
	this.time = time;
	// 'settings' requires a hard copy to be made so that when indexes are removed the orignal is unaffected, and can be passed in again.
	for (String[] line: settings) {
		this.settings.add(line);
	}

	setSettings();
	getIcons();


}

private void setSettings(){
	String[] bdColor = settings.get(0);
	String[] pColor = settings.get(1);
	String[] bgColor = settings.get(2);
	willDraw = Boolean.valueOf(settings.get(3)[0]);

	buildingColor = new Color( Integer.parseInt(bdColor[0]), Integer.parseInt(bdColor[1]), Integer.parseInt(bdColor[2]) );
	pathColor = new Color( Integer.parseInt(pColor[0]), Integer.parseInt(pColor[1]), Integer.parseInt(pColor[2]) );
	backgroundColor = new Color( Integer.parseInt(bgColor[0]), Integer.parseInt(bgColor[1]), Integer.parseInt(bgColor[2]) );

	// Removes these indexes so that the remaining icons can be iterated through.
	settings.remove(3); settings.remove(2); settings.remove(1); settings.remove(0);
}

// Creates a HashMap of the current icons in the folder "Icon-Files".
private void getIcons(){
	File folder = new File("./unimap/Icon-Files");
	File[] listOfFiles = folder.listFiles();
	for (File file : listOfFiles) {
		imageList.put(file.getName(), new ImageIcon("./unimap/Icon-Files/" + file.getName()) );
	}
}


// Overwritten super-class method that draws to the frame.
protected void paintComponent(Graphics g){

	Graphics2D g2 = (Graphics2D) g; // Graphics2D allows the pen-width to be changed (Graphics does not).

	// Draws the background.
	drawBackground(g2);

	// Draws a line between all the buildings on the path.
	drawPath(g2);

	// Draws the outline of the buildings.
	drawOutline(g2);

	// Draws all buildings.
	drawAllBuildings(g2);

	// Draws Map Legend if the user has put one.
	if (willDraw) {
		drawMapLegend(g2);
	}
}


private void drawBackground(Graphics2D g2) {
	g2.setColor(backgroundColor);
	g2.fillRect(0, 0, 1300, 800);
}


private void drawAllBuildings(Graphics2D g2) {
	for (String currentName : buildings.keySet()) {
		BuildingStructure currentB = buildings.get(currentName);
		String nameOfBuilding = currentB.getAbbreviation();

		int xcoord = (int)currentB.getX();
		int ycoord = 800 - ((int)currentB.getY());
		int length= (int)currentB.getLength();
		int height= (int)currentB.getHeight();

		//text for buildings
		g2.setFont(new Font("Time Roman", Font.BOLD, 14));
		g2.setColor(Color.BLACK);
		g2.drawString(nameOfBuilding, xcoord, ycoord-5);

		g2.setColor(buildingColor);
		g2.fillRect(xcoord,ycoord, length, height);
	}
}

private void drawOutline(Graphics2D g2) {
	for (String currentName : pathList) {
		BuildingStructure currentB = buildings.get(currentName);

		int xcoord = (int)currentB.getX();
		int ycoord = 800 - ((int)currentB.getY());
		int length= (int)currentB.getLength();
		int height= (int)currentB.getHeight();

		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2));
		g2.fillRect(xcoord - 2 ,ycoord - 2, length + 4, height + 4);
	}
}

private void drawPath(Graphics2D g2) {
	for (int i = 0; i<(pathList.size() - 1); i++ ) {
		int x1 = (int)buildings.get(pathList.get(i)).getX() + buildings.get(pathList.get(i)).getLength()/2;
		int x2 = (int)buildings.get(pathList.get(i+1)).getX() + buildings.get(pathList.get(i+1)).getLength()/2;
		int y1 = (int)buildings.get(pathList.get(i)).getY() - buildings.get(pathList.get(i)).getHeight()/2;
		int y2 = (int)buildings.get(pathList.get(i+1)).getY() - buildings.get(pathList.get(i+1)).getHeight()/2;

		g2.setStroke(new BasicStroke(6));
		g2.setColor(pathColor);
		g2.drawLine(x1,(800-y1),x2,(800-y2));
	}
}

private void drawMapLegend(Graphics g2) {
	int LX = Integer.parseInt(settings.get(0)[0]);
	int LY = Integer.parseInt(settings.get(0)[1]);
	BuildingStructure locationBuilding = buildings.get(pathList.get(0));
	BuildingStructure destinationBuilding = buildings.get(pathList.get(pathList.size()-1));

	// Draws parameter
	g2.setColor(Color.BLACK);
	g2.fillRect(LX-3, LY-3, Integer.parseInt(settings.get(0)[2])+6, Integer.parseInt(settings.get(0)[3])+6 );
	g2.setColor(Color.WHITE);
	g2.fillRect(LX, LY, Integer.parseInt(settings.get(0)[2]), Integer.parseInt(settings.get(0)[3]));
	settings.remove(0);

	// Draw legend contents
	g2.setFont(new Font("Algerian", Font.BOLD, 16));
	g2.setColor(Color.BLACK);
	g2.drawString("Map Legend", LX + 50, LY + 15);
	g2.setFont(new Font("Time Roman", Font.BOLD, 14));
	g2.drawString(time, LX + 130, LY + 43);

	g2.setFont(new Font("Time Roman", Font.PLAIN, 14));
	g2.setColor(pathColor);
	g2.fillRect(LX + 10, LY + 30, 30, 7);
	g2.setColor(Color.BLACK);
	g2.drawString("Path", LX + 50, LY + 40);


	// Adding these icons to the map legend could probably have been done in a loop, but some of the icons
	// were bigger than others, and so the spacing was slightly different.
	imageList.get("destination2.png").paintIcon(this, g2, LX + 10, LY +50);
	g2.drawString("Location", LX + 40, LY + 70);

	imageList.get("currentlocation2.png").paintIcon(this, g2, LX + 120, LY +50);
	g2.drawString("Destination", LX + 150, LY + 70);

	imageList.get("atm.png").paintIcon(this, g2, LX + 10, LY +78);
	g2.drawString("ATM", LX + 40, LY + 98);

	imageList.get("food.png").paintIcon(this, g2, LX + 120, LY +78);
	g2.drawString("Food", LX + 148, LY + 98);

	imageList.get("hospital.png").paintIcon(this, g2, LX + 10, LY +106);
	g2.drawString("Hostipal", LX + 40, LY + 125);

	imageList.get("hotel.png").paintIcon(this, g2, LX + 120, LY +106);
	g2.drawString("Hotel", LX + 148, LY + 125);

	imageList.get("library.png").paintIcon(this, g2, LX + 10, LY +132);
	g2.drawString("Library", LX + 40, LY + 153);

	imageList.get("mall.png").paintIcon(this, g2, LX + 120, LY +135);
	g2.drawString("Mall", LX + 148, LY + 155);

	imageList.get("parking.png").paintIcon(this, g2, LX + 10, LY +162);
	g2.drawString("Parking", LX + 40, LY + 182);

	imageList.get("shop.png").paintIcon(this, g2, LX + 120, LY +165);
	g2.drawString("Shop", LX + 148, LY + 185);

	imageList.get("theatre.png").paintIcon(this, g2, LX + 10, LY +188);
	g2.drawString("Theatre", LX + 40, LY + 208);

	imageList.get("toilet.png").paintIcon(this, g2, LX + 120, LY +192);
	g2.drawString("Bathroom", LX + 148, LY + 212);

	imageList.get("tourist.png").paintIcon(this, g2, LX + 10, LY +215);
	g2.drawString("Tour Spot", LX + 40, LY + 238);

	imageList.get("train.png").paintIcon(this, g2, LX + 120, LY +220);
	g2.drawString("Train", LX + 148, LY + 237);


	// Draws all of the images in the config txt file.
	for (String[] iconData: settings) {
		imageList.get(iconData[0]).paintIcon(this, g2, Integer.parseInt(iconData[1]), 800 - Integer.parseInt(iconData[2]) );
	}

	// Draws icons at location and destination.
	imageList.get("destination.png").paintIcon(this, g2, (int)locationBuilding.getX(), 800 - (int)locationBuilding.getY() );
	imageList.get("currentlocation.png").paintIcon(this, g2, (int)destinationBuilding.getX(), 800 - (int)destinationBuilding.getY() );

}


}
