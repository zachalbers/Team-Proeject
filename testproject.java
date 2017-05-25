
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("rawtypes")
public class testproject {



public static void gui()  {

		// transport combo box
		String [] transportmethod = {"Walk","Bike","Skateboard"};
		JComboBox<String> transport = new JComboBox<>(transportmethod);
		transport.setLayout(null);
		transport.setBounds(20,100,100,35);

		//Making a combo box
		String [] buildings = {"Mac Hall","Science B","Kinesiology A","Kinesiology B","Hotel Alma","MacEwan Student centre"};
		JComboBox<String> destination = new JComboBox<>(buildings);
		destination.setLayout(null);
		JComboBox<String> currentloc = new JComboBox<>(buildings);
		destination.setLayout(null);
		// Creates the main window of the gui
		JFrame window = new JFrame("UniMAP 2.0 BETA");   // "TeST PROGRAM" is Title of window
		window.setVisible(true);     // makes window visible
		window.setSize(500,500);     // set the dimensions of window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // So that gui closes when user clicks cross

		JPanel panels = new JPanel(); // Makes new panel
		panels.setBackground(Color.WHITE); // background colour of panel
		panels.setLayout(null); // enables us to put components anywhere in panel



		JLabel title = new JLabel("UniMAP 2.0 Beta");

		JButton exit = new JButton("Exit");   //Creates new button
		exit.setBounds(310,400,100,40); // sets position of button in panel
		panels.add(exit);  // Adds button to the panel
		JButton start = new JButton("GO");   //Creates new button
		start.setBounds(310,340,100,40); // sets position of button in panel
		panels.add(start);  // Adds button to the panel
		title.setLayout(null);
		title.setBounds(250,20,100,30);
		JLabel label = new JLabel("Do you want to bike or walk?");  //Creates new label
		label.setForeground(Color.BLACK);
		label.setLayout(null); //  Have to make label layout null for set bounds to work
		label.setBounds(0,50,1000,50); // sets position of button in panel
		panels.add(label);   // adds label to the panel
		destination.setBounds(250, 250, 150, 30);
		currentloc.setBounds(10, 250, 150, 30);
		panels.add(currentloc);
		panels.add(destination);
		panels.add(title);
		title.setForeground(Color.red); // Sets colour of the label

		JLabel walktime = new JLabel("Destination:");
		walktime.setLayout(null);
		walktime.setBounds(250,200,120,30);
		walktime.setForeground(Color.BLACK);
		JLabel walktime2 = new JLabel("CurrentLocation:");
		walktime2.setLayout(null);
		walktime2.setBounds(10,200,200,30);
		walktime2.setForeground(Color.BLACK);
		panels.add(walktime);
		panels.add(walktime2);
		panels.add(transport);
		window.add(panels); // Adds panel to the window




		// ACTION LISTENERS



		// EXIT BUTTON
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	System.exit(0);
		    }
		});


	// DROPDOWN CURRENT LOCATION
		currentloc.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	String startpoint = (String) currentloc.getSelectedItem();


		    }
		});

	// GO BUTTON
		start.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	String infoMessage="PROGRAM STARTS";
				  String titleBar = "UniMAP 2.0 ";
				  JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);
		    }
		});











}
	public static void main(String[] args) {
		gui();

	}

}
