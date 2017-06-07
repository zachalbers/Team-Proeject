import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GUI2 {

  // Variables for starting point, destination and list of buildings user has to go through to go to the destination
  String startpoint; String endpoint; String names;
  String buttonname="name";String NAME = "hello";
  int X=0;
  int Y=0;
  int width=0;
  int height=0;
  java.util.List<String> pathList2 = Collections.synchronizedList(new ArrayList<String>());

  // List that contains the options the user can select from the drop down menu for current location and destination
  String [] buildings = {"","Science A", "Science B", "Mac Hall", "MacEwan Student Centre", "Kinesiology A", "Kinesiology B",
    "Hotel Alma", "Olympic Oval", "Calgary Centre for Innovative Technology", "Schulich School of Engineering A-G",
    "Information and Communication Technologies", "Earth Science", "Math Science", "Science Theatres", "Social Science",
    "Administration", "Professional Faculties", "Education Classroom Block", "Education Tower"};

  //Constructor for buttons
  public void GUI2(int initialX, int initialY, int width, int height, String nameOfButton, String buttonDisplay) {

    this.X=initialX;
    this.Y=initialY;
    this.width=width;
    this.height=height;
    this.buttonname=nameOfButton;
    this.NAME = buttonDisplay;
    JButton buttonname = new JButton(NAME);
    buttonname.setBounds(X,Y,this.width,this.height);
  }
//
// // contructor for drop down menu current loc and destinationString
//   public void makecombobox(String boxName, int boxX, int boxY, int boxWidth, int boxHeight){
//     this.boxname=boxName;
//     JComboBox<String> boxname = new JComboBox<>(this.buildings);
//     boxname.setBounds(boxX,boxY,boxWidth, boxHeight);
//   }
// // constructor for making labels
//   public void makejlabel (String labelName, String labelContent, int labelX, int labelY, int labelWidth, int labelHeight ) {
//     this.labelname=labelName;
//     JLabel labelname= new JLabel(labelContent);
//     labelname.setLayout(null);
//     labelname.setBounds(labelX,labelY, labelWidth, labelHeight);
//   }
// // constructor for making windows
//   public void makewindow(String windowName,int windowWidth, int windowHeight,String windowTitle){
//     this.windowname= windowName;
//     JFrame windowname = new JFrame(windowTitle);
//     windowname.setVisible(true);
//     windowname.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     windowname.setSize(windowWidth,windowHeight);
//   }
// // constructor for making panels
//   public void makepanel(String panelName){
//     this.panelname = panelName;
//     JPanel panelname = new JPanel();
//     panelname.setBackground(Color.WHITE);
//     panelname.setLayout(null);
//   }
//
//
// // Creating the components for the GUI using the constructors:
// //Creating the buttons:
//
// //GO button
//

//Exit button
// public void creatingcomponents(){
//   makebutton (710, 400, 55, 20, "GO", "GO");
//   makebutton (710,450,55,20, "exit", "Exit");
// }


public static void main(String args[]){
GUI2 gui = new GUI2();
gui.GUI2(710, 400, 55, 20, "GO", "GO");
}
























































































































}
