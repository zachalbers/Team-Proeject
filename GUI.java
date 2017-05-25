
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

	public static void gui(){


		//OBJECTS                         ++++++++++++++++++++++++++++++++++++++++++
		//Main menu objects
		//Combo box for destination and CurrentLocation
		String [] buildings = {"Mac Hall","Science B","Kinesiology A","Kinesiology B","Hotel Alma","MacEwan Student Centre"};
		JComboBox<String> destination = new JComboBox<>(buildings);

		JComboBox<String> currentloc = new JComboBox<>(buildings);

		destination.setBounds(500,100,250,20);
		currentloc.setBounds(100,100,250,20);

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
		String [] transportmethod = {"Walk","Bike","Skateboard"};
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
			    	String startpoint = (String) currentloc.getSelectedItem();
						String titleBar = "UniMAP";
						JOptionPane.showMessageDialog(null, "Current Location: " + startpoint,titleBar, JOptionPane.INFORMATION_MESSAGE);


			    }
			});
			// DROPDOWN destination
				destination.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e)
				    {
				    	String endpoint = (String) destination.getSelectedItem();
							String titleBar = "UniMAP";
							JOptionPane.showMessageDialog(null, "Destination: " + endpoint,titleBar, JOptionPane.INFORMATION_MESSAGE);


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
		    	String infoMessage="PROGRAM STARTS";
				String titleBar = "UniMAP";
				JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
		    }
		});






		//Adding panel to windows         ++++++++++++++++++++++++++++++++++++++++++++++++
		//Main menu window panel
		menuwindow.add(menupanel);






	}




// THE main method of the code that executes all other methods
public static void main(String[] args) {
	// Calling main menu gui() method
	gui();

}





















}
