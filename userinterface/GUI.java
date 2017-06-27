/*
This class contains the main method from which the program is run.
It contains the file chooser GUI which has the user select a valid text file, and then creates an instance of MapData to get the map info.
It also contains the main window from which the user selects the location, destination, and transport method.
These variables are then used to initiate the 'Pathfinder' instance and its 'getFinalDistance' and 'pathfind' methods.
These parameters along with the Hashmap of buildings are passed into MapWindow, which is drawn once the user clicks go.
*/




package unimap.userinterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.DefaultListCellRenderer;
import javax.swing.filechooser.FileNameExtensionFilter;
import unimap.programlogic.*;




public class GUI {


//instance variables
MapData mapData = new MapData(getFileName());

String[] buildingNames = mapData.buildings.keySet().toArray(new String[mapData.buildings.keySet().size()]);

java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
String [] transportmethod = {"Walk", "Run","Skate","Bike",};
String startpoint, endpoint, names, travelMethod="Walk";

JButton go, exit;
JLabel currentlabel, destinationlabel, transportlabel, questionlabel, golabel;
JLabel exitlabel, walklabel, runlabel, skatelabel, uofclabel, cur, des;
ImageIcon goimage, exitimage, walkicon, runicon, desicon;
ImageIcon curicon, uofcicon, skateicon, questionicon;

JComboBox<String> currentbox; JComboBox<String> destinationbox; JComboBox<String> transportbox;
JFrame MenuWindow; JPanel MenuPanel;
Double finalDistance;


// constructor for GUI:
public GUI(){
	makeButtons();
	makeDropdownMenu();
	makeLabels();
	initializeScreen();
	addComponents();
	actionListeners();
	startGUI();
}

//Prompts the user to enter what map they want to use and returns the name of the map as a String
public String getFileName(){
	  JFileChooser fc= new JFileChooser();
	  FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
	  fc.setFileFilter(filter);
	  fc.setCurrentDirectory(new File("./unimap/Map-Files"));
	  fc.setDialogTitle("Choose map file");
	  fc.setApproveButtonText("Select Map");
	  fc.setAcceptAllFileFilterUsed(false);
	  int ret = fc.showOpenDialog(null);

	  if (ret == JFileChooser.APPROVE_OPTION)
	  {
		  File file = fc.getSelectedFile();
		  String filename= file.getAbsolutePath();
		  return file.getName();
	  } else if (ret == JFileChooser.CANCEL_OPTION){
		  System.exit(0);
		  return null;
	  } else
		 System.exit(0);
		 return null;
  	  }


// Creates a new Pathfinder instance and gets the pathList and finalDistance.
public void getPath(){
	Pathfinder finder = new Pathfinder(mapData.buildings);
	pathList = finder.pathfind(startpoint, endpoint);
	finalDistance = finder.getFinalDistance();
}

// Opens the Map Window.
public void openWindow(){
	JFrame Frame = new JFrame("Title");
	MapWindow window = new MapWindow(pathList, mapData.buildings, mapData.settings, getDistance());
	Frame.add(window);
	Frame.setSize(1300, 800);
	Frame.setVisible(true);
	Frame.setResizable(false);
}

// Initializes the screen
public void initializeScreen(){
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

// Adds the panel that contains all components to the window.
public void startGUI(){
	MenuWindow.add(MenuPanel);
}

// Makes the button components of the GUI.
public void makeButtons(){
	JButton go = new JButton("");
	go.setBounds(110,375,110,110);
	go.setOpaque(false);
	go.setContentAreaFilled(false);
	go.setBorderPainted(false);
	this.go = go;
	goimage = new ImageIcon("./unimap/Gui-Icon-Files/go.jpg");
	golabel = new JLabel(goimage);
	golabel.setLayout(null);
	golabel.setBounds(110,375,130,130);
	JButton exit = new JButton("");
	exit.setBounds(115,519,110,110);
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	this.exit=exit;
	exitimage = new ImageIcon("./unimap/Gui-Icon-Files/exitbutton.png");
	exitlabel = new JLabel(exitimage);
	exitlabel.setLayout(null);
	exitlabel.setBounds(110,515,130,130);
}

// Makes the label components of the GUI.
public void makeLabels(){
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
	walkicon = new ImageIcon("./unimap/Gui-Icon-Files/walk.jpg");
	walklabel = new JLabel(walkicon);
	walklabel.setLayout(null);
	walklabel.setBounds(300,430,80,80);
	runicon = new ImageIcon("./unimap/Gui-Icon-Files/run.jpg");
	runlabel = new JLabel(runicon);
	runlabel.setLayout(null);
	runlabel.setBounds(400,430,80,80);
	skateicon = new ImageIcon("./unimap/Gui-Icon-Files/skateboard.jpg");
	skatelabel = new JLabel(skateicon);
	skatelabel.setLayout(null);
	skatelabel.setBounds(500,430,80,80);
	questionicon = new ImageIcon("./unimap/Gui-Icon-Files/questionmark.jpg");
	questionlabel = new JLabel(questionicon);
	questionlabel.setLayout(null);
	questionlabel.setBounds(600,430,80,80);
	uofcicon = new ImageIcon("./unimap/Gui-Icon-Files/logo2.png");
	uofclabel = new JLabel(uofcicon);
	uofclabel.setLayout(null);
	uofclabel.setBounds(840,75,450,560);
	curicon = new ImageIcon("./unimap/Gui-Icon-Files/currentloc.png");
	cur = new JLabel(curicon);
	cur.setLayout(null);
	cur.setBounds(720,100,78,78);
	desicon = new ImageIcon("./unimap/Gui-Icon-Files/des.jpg");
	des = new JLabel(desicon);
	des.setLayout(null);
	des.setBounds(720,230,78,78);
}

// Makes the dropdown components of the GUI.
public void makeDropdownMenu(){
	Arrays.sort(buildingNames);
	startpoint=buildingNames[0];
	endpoint=buildingNames[0];
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

// Adds all the GUI components to the panel.
public void addComponents(){
	MenuPanel.add(exit);
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


// Calculates the time the user takes depending on the travel method they select and returns the time as a String.
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


// Manages action listeners for the components of the GUI.
public void actionListeners(){
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

	exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});

	go.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			getPath();
			openWindow();
		}
	});

}

// Main method of the program.
public static void main(String[] args) {
	GUI userInfo = new GUI();
}

}
