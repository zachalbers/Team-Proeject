import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("rawtypes")
public class GUI {

  public static void gui()  {
    //Making the menu window
    JFrame mainWindow = new JFrame("UniMAP");   // "TeST PROGRAM" is Title of window
		mainWindow.setVisible(true);     // makes window visible
		mainWindow.setSize(500,500);     // set the dimensions of window
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // So that gui closes when user clicks cross

    // Makes panel for menu window
    JPanel menupanel = new JPanel();
		menupanel.setBackground(Color.BLACK); // background colour of panel
		menupanel.setLayout(null); // enables us to put components anywhere in panel

    //OBJECTS IN PANEL
    // transport combo box
		String [] transportmethod = {"Walk","Bike","Skateboard"};
		JComboBox<String> transport = new JComboBox<>(transportmethod);
		transport.setLayout(null);
		transport.setBounds(250,250,100,100);
    // EXIT BUTTON
    JButton exit = new JButton("Exit");
		exit.setBounds(250,250,100,40);


    //adds objects to main menu panel
    menupanel.add(transport);
    menupanel.add(exit);
    // ADDS PANEL TO MENU WINDOW
    mainWindow.add(menupanel);


  }
  //MAIN METHOD
  public static void main(String[] args) {
		gui();

  }



























































































}
