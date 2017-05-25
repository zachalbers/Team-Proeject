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
		exit.setBounds(310,400,100,40); 
		menupanel.add(exit);  
		
		
		
		// ADDING OBJECTS                  +++++++++++++++++++++++++++++++++++++++++
		// Main menu adding objects to panel
		
		
		
		
		
		
		
		
		
		//ACTION LISTENERS                 ++++++++++++++++++++++++++++++++++++++++++
		// Action listeners for main window
		exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	System.exit(0);
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
	
	
	

	