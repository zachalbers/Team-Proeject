import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.*;

// Class for making the map   ++++++++++++
public class MapWindow extends JPanel{


	public void drawbuildings(){
		JFrame Frame = new JFrame("Title");
		MapWindow shapes = new MapWindow(pathList);
		Frame.add(shapes);
		Frame.setSize(1300, 800);
		Frame.setVisible(true);
	}


	java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());


	public MapWindow(java.util.List<String> pathList) {
	this.pathList = pathList;
	}

	// method that draws the buildings and its names  ++++++++++++++++
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(new Color(173, 216, 189));


		ConfigReader map1= new ConfigReader();
		map1.readFile();


		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));



		for (int i = 0; i<(pathList.size() - 1);i++ ) {
							int x1 = (int)map1.buildings.get(pathList.get(i)).getX();
							int x2 = (int)map1.buildings.get(pathList.get(i+1)).getX();
							int y1 = (int)map1.buildings.get(pathList.get(i)).getY();
							int y2 = (int)map1.buildings.get(pathList.get(i+1)).getY();

							g.setColor(new Color(198,117, 31));
							g.drawLine(x1,(800-y1),x2,(800-y2));
		}




		for (String currentName : map1.buildings.keySet()) {
				BuildingStructure currentB = map1.buildings.get(currentName);

				int xcoord = (int)currentB.getX();
				int ycoord = 800 - ((int)currentB.getY());
				int length= (int)currentB.getLength();
				int height= (int)currentB.getHeight();

				String nameOfBuilding = currentB.getAbbreviation();

				//text for buildings
				g.setColor(Color.BLACK);
				g.drawString(nameOfBuilding, xcoord, ycoord);



				//draw pathway from cuurent to destination

				g.setColor(new Color(99, 104, 108));
				g.fillRect(xcoord,ycoord, length*7, height*7);
		}


		for (String currentName : pathList) {
				BuildingStructure currentB = map1.buildings.get(currentName);

				int xcoord = (int)currentB.getX();
				int ycoord = 800 - ((int)currentB.getY());
				int length= (int)currentB.getLength();
				int height= (int)currentB.getHeight();

			g.setColor(Color.RED);
			g2.setStroke(new BasicStroke(2));
			g.drawLine(xcoord, ycoord, xcoord, ycoord + height*7);
			g.drawLine(xcoord, ycoord, xcoord + length*7, ycoord);
			g.drawLine(xcoord + length*7, ycoord, xcoord + length*7, ycoord + height*7);
			g.drawLine(xcoord, ycoord + height*7, xcoord + length*7, ycoord + height*7);

	}




// COlor for everythiNg = new Color(193, 110, 110)






}
}
