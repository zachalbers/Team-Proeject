
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI {


	String startpoint; String endpoint; String names;

	public void gui(){


		//OBJECTS                         ++++++++++++++++++++++++++++++++++++++++++
		//Main menu objects
		//Combo box for destination and CurrentLocation
		String [] buildings = {"","Science A", "Science B", "Mac Hall", "MacEwan Student Centre", "Kinesiology A", "Kinesiology B",
			"Hotel Alma", "Olympic Oval", "Calgary Centre for Innovative Technology", "Schulich School of Engineering A-G",
			"Information and Communication Technologies", "Earth Science", "Math Science", "Science Theatres", "Social Science",
			"Administration", "Professional Faculties", "Education Classroom Block", "Education Tower"};
		JComboBox<String> destination = new JComboBox<>(buildings);

		JComboBox<String> currentloc = new JComboBox<>(buildings);

		destination.setBounds(500,100,350,20);
		currentloc.setBounds(100,100,350,20);

		//MAIN MENU LABELS
		JLabel currentLabel = new JLabel("Select Current Location: ");
		currentLabel.setLayout(null);
		currentLabel.setBounds(110,77,250,20);
		JLabel destinationLabel = new JLabel("Select Destination: ");
		destinationLabel.setLayout(null);
		destinationLabel.setBounds(510,77,250,20);
		JLabel transportLabel = new JLabel("Method Of Transportation: ");
		transportLabel.setLayout(null);
		transportLabel.setBounds(110,380,250,20);

		//Transporation combo box
		String [] transportmethod = {"","Walk","Bike","Skateboard"};
		JComboBox<String> transport = new JComboBox<>(transportmethod);
		transport.setBounds(100,400,250,20);






		// The exit button
		JButton exit = new JButton("Exit");
		exit.setBounds(710,450,55,20);

		// The GO Button
		JButton GO = new JButton("GO");
		GO.setBounds(710,400,55,20);

		//WINDOWS                        +++++++++++++++++++++++++++++++++++
		// Main Menu Window
		JFrame menuwindow = new JFrame("UniMAP");
		menuwindow.setVisible(true);
		menuwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuwindow.setSize(850,600);

		//PANELS                         ++++++++++++++++++++++++++++++++++++++
		// Main Menu Panel
		JPanel menupanel = new JPanel();
		menupanel.setBackground(Color.WHITE);
		menupanel.setLayout(null);










		// ADDING OBJECTS                  +++++++++++++++++++++++++++++++++++++++++
		// Main menu adding objects to panel
		menupanel.add(exit);    // add exit button
		menupanel.add(GO);      // ad GO button
		menupanel.add(destination); //adds destination combo box
		menupanel.add(currentloc); //adds currentloc combo box
		menupanel.add(currentLabel); //adds label to current combo
		menupanel.add(destinationLabel); //adds label to destination combo
		menupanel.add(transport); //adds transporation combo box to menu panel
		menupanel.add(transportLabel); // Label for transportation








		//ACTION LISTENERS                 ++++++++++++++++++++++++++++++++++++++++++
		// Action listeners for main window

		// DROPDOWN CURRENT LOCATION
			currentloc.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			    	startpoint = (String) currentloc.getSelectedItem();


			    }
			});
			// DROPDOWN destination
				destination.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e)
				    {
				    	endpoint = (String) destination.getSelectedItem();


				    }
				});
				// DROPDOWN Transporation
					transport.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e)
					    {
					    	String goMethod = (String) transport.getSelectedItem();
								String titleBar = "UniMAP";
								JOptionPane.showMessageDialog(null, "Your transport method is: " + goMethod,titleBar, JOptionPane.INFORMATION_MESSAGE);


					    }
					});

		//Exit button
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	System.exit(0);
		    }
		});

		//GO button
		GO.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
					execute();

				String infoMessage= names;
				String titleBar = "UniMAP";
				JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);





		    }


		});











		//Adding panel to windows         ++++++++++++++++++++++++++++++++++++++++++++++++
		//Main menu window panel
		menuwindow.add(menupanel);






	}




// // THE main method of the code that executes all other methods
// public static void main(String[] args) {
// 	// Calling main menu gui() method
// 	gui();
//
// }







public void execute(){

	AllBuildings nextBuildingObj = new AllBuildings();
	Building locationObj = nextBuildingObj.buildings(startpoint);
	Building destinationObj = nextBuildingObj.buildings(endpoint);



	Pathfinder finder = new Pathfinder();
	finder.pathfind(locationObj, destinationObj, nextBuildingObj);
	names = finder.nameString;


}













}
