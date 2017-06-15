import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.DefaultListCellRenderer;


public class GUI {




	public String getFileName(){

	File folder = new File("./Map-Files");
  File[] listOfFiles = folder.listFiles();

  System.out.println("");
  for (File x : listOfFiles) {
    System.out.println(x.getName());
  }

  Scanner keyboard = new Scanner(System.in);
  System.out.println("");
  System.out.print("Enter name of Map File: ");
  String fileName = keyboard.nextLine();
	return fileName;
}



//instance variables
 //MapData mapData = new MapData(getFileName());
MapData mapData = new MapData("Uni.txt");


String[] buildingNames = mapData.buildings.keySet().toArray(new String[mapData.buildings.keySet().size()]);
java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());

String startpoint; String endpoint; String names; String travelMethod;
String [] transportmethod = {"Walk", "Run","Skate","Bike",};
JButton go; JButton EXIT;
JLabel currentlabel; JLabel destinationlabel; JLabel transportlabel;
ImageIcon goimage;ImageIcon exitimage;ImageIcon walkicon;ImageIcon runicon;ImageIcon skateicon;ImageIcon questionicon;ImageIcon uofcicon;
ImageIcon curicon;ImageIcon desicon;
JLabel golabel;JLabel exitlabel;JLabel walklabel;JLabel runlabel;JLabel skatelabel;JLabel questionlabel;JLabel uofclabel;
JLabel cur;JLabel des;


JComboBox<String> currentbox; JComboBox<String> destinationbox; JComboBox<String> transportbox;
JFrame MenuWindow; JPanel MenuPanel;
Double finalDistance;




// contructor for GUI:
public GUI(){
	makebutton();
	makedropdownmenu();
	makelabels();
	initializescreen();
	addcomponents();
	actionlisteners();
	startgui();
}




//initializes the screen:
public void initializescreen(){
		JFrame menuwindow = new JFrame("UNIMAP - Helping you Find your Way");
		menuwindow.setVisible(true);
		menuwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuwindow.setSize(1400,700);
		menuwindow.setResizable(false);
		this.MenuWindow=menuwindow;
		JPanel menupanel = new JPanel();
		this.MenuPanel=menupanel;
		menupanel.setBackground(Color.WHITE);
		menupanel.setLayout(null);

	}

// adds the panel that contains all components to the window:
public void startgui(){
		MenuWindow.add(MenuPanel);
}

// makes the button components of the gui
public void makebutton(){
		JButton GO = new JButton("");
		GO.setBounds(110,375,110,110);
		GO.setOpaque(false);
		GO.setContentAreaFilled(false);
		GO.setBorderPainted(false);
		this.go = GO;
		goimage = new ImageIcon("./Gui-Icon-Files/go.jpg");
		golabel = new JLabel(goimage);
		golabel.setLayout(null);
		golabel.setBounds(110,375,130,130);
		JButton exit = new JButton("");
		exit.setBounds(115,519,110,110);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		this.EXIT=exit;
		exitimage = new ImageIcon("./Gui-Icon-Files/exitbutton.png");
		exitlabel = new JLabel(exitimage);
		exitlabel.setLayout(null);
		exitlabel.setBounds(110,515,130,130);
	}

// makes the label components of the gui
public void makelabels(){
		JLabel currentLabel = new JLabel("Current Location: ");
		currentLabel.setLayout(null);
		currentLabel.setBounds(110,77,250,20);
		currentLabel.setFont(new Font("Algerian", Font.BOLD, 20));
		this.currentlabel=currentLabel;
		JLabel destinationLabel = new JLabel("Destination: ");
		destinationLabel.setLayout(null);
		destinationLabel.setBounds(110,195,250,20);
		this.destinationlabel=destinationLabel;
		destinationlabel.setFont(new Font("Algerian", Font.BOLD, 20));
		JLabel transportLabel = new JLabel("Method Of Transportation: ");
		transportLabel.setLayout(null);
		transportLabel.setBounds(300,380,350,20);
		transportLabel.setFont(new Font("Algerian", Font.BOLD, 20));
		this.transportlabel=transportLabel;
		walkicon = new ImageIcon("./Gui-Icon-Files/walk.jpg");
		walklabel = new JLabel(walkicon);
		walklabel.setLayout(null);
		walklabel.setBounds(300,430,80,80);
		runicon = new ImageIcon("./Gui-Icon-Files/run.jpg");
		runlabel = new JLabel(runicon);
		runlabel.setLayout(null);
		runlabel.setBounds(400,430,80,80);
		skateicon = new ImageIcon("./Gui-Icon-Files/skateboard.jpg");
		skatelabel = new JLabel(skateicon);
		skatelabel.setLayout(null);
		skatelabel.setBounds(500,430,80,80);
		questionicon = new ImageIcon("./Gui-Icon-Files/questionmark.jpg");
		questionlabel = new JLabel(questionicon);
		questionlabel.setLayout(null);
		questionlabel.setBounds(600,430,80,80);
		uofcicon = new ImageIcon("./Gui-Icon-Files/logo2.png");
		uofclabel = new JLabel(uofcicon);
		uofclabel.setLayout(null);
		uofclabel.setBounds(840,75,450,560);
		curicon = new ImageIcon("./Gui-Icon-Files/currentloc.png");
		cur = new JLabel(curicon);
		cur.setLayout(null);
		cur.setBounds(720,100,78,78);
		desicon = new ImageIcon("./Gui-Icon-Files/des.jpg");
		des = new JLabel(desicon);
		des.setLayout(null);
		des.setBounds(720,230,78,78);
}

// makes the dropdown components of the gui
public void makedropdownmenu(){
		JComboBox<String> destination = new JComboBox<>(buildingNames);
		destination.setBounds(110,230,600,78);
		this.destinationbox=destination;
		JComboBox<String> currentloc = new JComboBox<>(buildingNames);
		currentloc.setBounds(110,100,600,78);
		this.currentbox=currentloc;
		JComboBox<String> transport = new JComboBox<>(transportmethod);
		transport.setBounds(300,550,380,65);
		this.transportbox=transport;
}

// adds all the gui components to the panel
public void addcomponents(){
		MenuPanel.add(EXIT);
		MenuPanel.add(go);
		MenuPanel.add(destinationbox);
		MenuPanel.add(currentbox);
		MenuPanel.add(currentlabel);
		MenuPanel.add(destinationlabel);
		MenuPanel.add(transportbox);
		MenuPanel.add(transportlabel);
		MenuPanel.add(golabel);
		MenuPanel.add(exitlabel);
		MenuPanel.add(walklabel);
		MenuPanel.add(runlabel);
		MenuPanel.add(skatelabel);
		MenuPanel.add(questionlabel);
		MenuPanel.add(uofclabel);
		MenuPanel.add(cur);
		MenuPanel.add(des);
}

// draws the buildings on the mapwindow:
public void gowindow(){



	 	JFrame Frame = new JFrame("Title");
		MapWindow window = new MapWindow(pathList, mapData.buildings, mapData.settings, getDistance());
		Frame.add(window);
		Frame.setSize(1300, 800);
		Frame.setVisible(true);





}

//gets the buildings user has to go through from start to end point
public void getPath(){
		Pathfinder finder = new Pathfinder(mapData.buildings);
		pathList = finder.pathfind(startpoint, endpoint);
		finalDistance = finder.getFinalDistance();
}


public String getDistance(){
	int minutes;
	int seconds;
	String time;

	switch (travelMethod) {
		case "Walk" : seconds = (int)(finalDistance / 1.4);
									break;
		case "Run" : seconds = (int)(finalDistance / 2.69);
									break;
		case "Skate" : seconds = (int)(finalDistance / 3.2);
									break;
		case "Bike" : seconds = (int)(finalDistance / 4.29);
									break;
		default : seconds = 0;
	}

	minutes = seconds / 60;
	seconds = seconds % 60;
	time = travelMethod + " time: " + Integer.toString(minutes) + " min " + Integer.toString(seconds) + " sec";
	return time;


}

// manages action listeners for the components of the gui
public void actionlisteners(){
		currentbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						startpoint = (String) currentbox.getSelectedItem();
				}
		});
		destinationbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						endpoint = (String) destinationbox.getSelectedItem();
				}
		});
		transportbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						travelMethod = (String) transportbox.getSelectedItem();
				}
		});
		EXIT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						System.exit(0);
				}
			});
			go.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						getPath();
						gowindow();
				}
		});
}

// Main method of the program
	public static void main(String[] args) {
		GUI userInfo = new GUI();
		}
}
