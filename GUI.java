import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.Icon;

//
public class GUI {


String startpoint; String endpoint; String names;
JButton go; JButton EXIT;
JLabel currentlabel; JLabel destinationlabel; JLabel transportlabel;
JComboBox<String> currentbox; JComboBox<String> destinationbox; JComboBox<String> transportbox;
JFrame MenuWindow; JPanel MenuPanel;






ConfigReader map2 = new ConfigReader();
Set<String> b = map2.buildings.keySet();
String[] buildingNames = b.toArray(new String[b.size()]);



String [] transportmethod = {"","Walk","Bike","Skateboard"};
java.util.List<String> pathList = Collections.synchronizedList(new ArrayList<String>());



public void initializescreen(){
		JFrame menuwindow = new JFrame("UniMAP");
		menuwindow.setVisible(true);
		menuwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuwindow.setSize(1000,600);
		this.MenuWindow=menuwindow;


		JPanel menupanel = new JPanel();
		this.MenuPanel=menupanel;
		menupanel.setBackground(Color.WHITE);
		menupanel.setLayout(null);


}


public void startgui(){
		MenuWindow.add(MenuPanel);
}


public void makebutton(){
		JButton GO = new JButton("GO");
		GO.setBounds(910,400,55,20);
		this.go = GO;

		JButton exit = new JButton("Exit");
		exit.setBounds(910,450,55,20);
		this.EXIT=exit;

}

public void makelabels(){
		JLabel currentLabel = new JLabel("Select Current Location: ");
		currentLabel.setLayout(null);
		currentLabel.setBounds(110,77,250,20);
		this.currentlabel=currentLabel;
		JLabel destinationLabel = new JLabel("Select Destination: ");
		destinationLabel.setLayout(null);
		destinationLabel.setBounds(510,77,250,20);
		this.destinationlabel=destinationLabel;
		JLabel transportLabel = new JLabel("Method Of Transportation: ");
		transportLabel.setLayout(null);
		transportLabel.setBounds(110,380,250,20);
		this.transportlabel=transportLabel;
}

public void makedropdownmenu(){





		JComboBox<String> destination = new JComboBox<>(buildingNames);
		destination.setBounds(500,100,350,20);
		this.destinationbox=destination;
		JComboBox<String> currentloc = new JComboBox<>(buildingNames);
		currentloc.setBounds(100,100,350,20);
		this.currentbox=currentloc;
		JComboBox<String> transport = new JComboBox<>(transportmethod);
		transport.setBounds(100,400,250,20);
		this.transportbox=transport;
}



public void addcomponents(){
		MenuPanel.add(EXIT);
		MenuPanel.add(go);
		MenuPanel.add(destinationbox);
		MenuPanel.add(currentbox);
		MenuPanel.add(currentlabel);
		MenuPanel.add(destinationlabel);
		MenuPanel.add(transportbox);
		MenuPanel.add(transportlabel);
}


public void gowindow(){
		MapWindow window = new MapWindow(pathList, map2.buildings);
		window.drawbuildings();
}



public void getPath(){


		Pathfinder finder = new Pathfinder(map2.buildings);
		pathList = finder.pathfind(startpoint, endpoint);
}



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
						String goMethod = (String) transportbox.getSelectedItem();
						String titleBar = "UniMAP";
						JOptionPane.showMessageDialog(null, "Your transport method is: " +
							goMethod,titleBar, JOptionPane.INFORMATION_MESSAGE);
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
						String infoMessage= names;
						String titleBar = "UniMAP";
						JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
						gowindow();
				}
		});


		}


}
