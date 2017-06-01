// imports required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// Class for GUI
public class GUI {

			// Variables for starting , destination and list of buildings user has to go through to go to the destination
			String startpoint; String endpoint; String names;


			//Method for main menu of gui. It creates the window , a panel , all the buttons , drop down menus and adds all the gui components to the jframe and window.
			public void gui(){


				// Defining and creating components of the GUI: ****************************************************************************************************

				//Creating Combo box for destination and CurrentLocation
				// List that contains the options the user can select from the drop down menu for current location and destination
				String [] buildings = {"","Science A", "Science B", "Mac Hall", "MacEwan Student Centre", "Kinesiology A", "Kinesiology B",
					"Hotel Alma", "Olympic Oval", "Calgary Centre for Innovative Technology", "Schulich School of Engineering A-G",
					"Information and Communication Technologies", "Earth Science", "Math Science", "Science Theatres", "Social Science",
					"Administration", "Professional Faculties", "Education Classroom Block", "Education Tower"};

				JComboBox<String> destination = new JComboBox<>(buildings);           // makes combo box destination

				JComboBox<String> currentloc = new JComboBox<>(buildings);	      // makes combo box currentlocation

				destination.setBounds(500,100,350,20);
				currentloc.setBounds(100,100,350,20);

				//Transporation method combo box
				String [] transportmethod = {"","Walk","Bike","Skateboard"};
				JComboBox<String> transport = new JComboBox<>(transportmethod);
				transport.setBounds(100,400,250,20);


				//Creating the labels of the main menu: ***************************************************************************************************************
				JLabel currentLabel = new JLabel("Select Current Location: ");
				currentLabel.setLayout(null);
				currentLabel.setBounds(110,77,250,20);
				JLabel destinationLabel = new JLabel("Select Destination: ");
				destinationLabel.setLayout(null);
				destinationLabel.setBounds(510,77,250,20);
				JLabel transportLabel = new JLabel("Method Of Transportation: ");
				transportLabel.setLayout(null);
				transportLabel.setBounds(110,380,250,20);


				// Creates the exit and add button on the gui: ********************************************************************************************************
				// The exit button
				JButton exit = new JButton("Exit");
				exit.setBounds(710,450,55,20);

				// The GO Button
				JButton GO = new JButton("GO");
				GO.setBounds(710,400,55,20);

				//Creating the window for the main menu:      *********************************************************************************************************
				JFrame menuwindow = new JFrame("UniMAP");
				menuwindow.setVisible(true);
				menuwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menuwindow.setSize(850,600);

				// Creating the jpanel over the mainwindow to place all the gui components to put into: ***************************************************************
				JPanel menupanel = new JPanel();
				menupanel.setBackground(Color.WHITE);
				menupanel.setLayout(null);


				// Adding all the gui components to the panel :  ******************************************************************************************************
				menupanel.add(exit);
				menupanel.add(GO);
				menupanel.add(destination);
				menupanel.add(currentloc);
				menupanel.add(currentLabel);
				menupanel.add(destinationLabel);
				menupanel.add(transport);
				menupanel.add(transportLabel);



				//Action listeners for the buttons and drop down menus on the GUI: *************************************************************************************

				// action listener for dropdown current location:
					currentloc.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e) {
							  				startpoint = (String) currentloc.getSelectedItem();
									}
					});

				// action listener for dropdown destination:
					destination.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
						 					endpoint = (String) destination.getSelectedItem();
						 	}
					});

				// action listener for Transporation dropdown
					transport.addActionListener(new ActionListener() {
					      public void actionPerformed(ActionEvent e) {
						 String goMethod = (String) transport.getSelectedItem();
					         String titleBar = "UniMAP";
						 JOptionPane.showMessageDialog(null, "Your transport method is: " + goMethod,titleBar, JOptionPane.INFORMATION_MESSAGE);
		                                 }
						});

				//action listener for exit button
				exit.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    			System.exit(0);
				    }
				});

				//action listener for GO button
				GO.addActionListener(new ActionListener() {
				    		public void actionPerformed(ActionEvent e) {
												execute();
												String infoMessage= names;
												String titleBar = "UniMAP";
												JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
												// gowindow();
								}
					});

				menuwindow.add(menupanel);   // Adding the jpanel to the windows

				}


		////public void gowindow(){          /////   not needed for this demo
		////	frame frame1 = new frame(); /////    not needed for this demo
		////	frame1.drawbuildings();     /////    not needed for this demo
		////}				    /////    not needed for this demo



		// Method that calls the pathfinding algorithm: *************************************************************************************************************************
			public void execute(){

				Pathfinder finder = new Pathfinder();
				finder.pathfind(startpoint, endpoint);
				names = finder.nameString;
			}







}
