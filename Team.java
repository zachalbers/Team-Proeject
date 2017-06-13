import java.io.*;
import java.lang.Object;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.Icon;

// This is the main class that is run.

public class Team {






public void start() {
    GUI userInfo = new GUI();
}

public static void main(String[] args) {



  File folder = new File("./Map-Files");
  File[] listOfFiles = folder.listFiles();

  System.out.println("");
  for (File x : listOfFiles) {
    System.out.println(x.getName());
  }

  Scanner keyboard = new Scanner(System.in);
  System.out.println("");
  System.out.print("Enter name of Map File: ");
  String FileName = keyboard.nextLine();



    Team main = new Team();
    main.start();
}
}
