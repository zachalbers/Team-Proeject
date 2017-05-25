package testproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
	
	public static void gui(){
		//WINDOWS                        +++++++++++++++++++++++++++++++++++ 
		// Main Menu Window
		JFrame menuwindow = new JFrame("UniMAP"); 
		menuwindow.setVisible(true);     
		menuwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		menuwindow.setSize(500,500);
		
		
		
		
		
		
		//PANELS                         ++++++++++++++++++++++++++++++++++++++
		// Main Menu Panel
		JPanel menupanel = new JPanel(); 
		menupanel.setBackground(Color.WHITE); 
		menupanel.setLayout(null); 
		
		
		
		
		//OBJECTS                         ++++++++++++++++++++++++++++++++++++++++++
		//Main menu objects         
		// The exit button 
		JButton exit = new JButton("Exit");  
		exit.setBounds(310,400,55,20); 
		  
		// The GO Button
		JButton GO = new JButton("GO");  
		GO.setBounds(310,350,55,20); 
	
		
		
		
		// ADDING OBJECTS                  +++++++++++++++++++++++++++++++++++++++++
		// Main menu adding objects to panel
		menupanel.add(exit);    // add exit button
		menupanel.add(GO);      // ad GO button
		
		
		
		
		
		
		
		//ACTION LISTENERS                 ++++++++++++++++++++++++++++++++++++++++++
		// Action listeners for main window
		
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
	
	
	

	