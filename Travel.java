// This class gets user input for location and destination from the command prompt.

import java.util.Scanner;

public class Travel {

        //Gets and returns location
        public String getLocation() {
                  System.out.print("Enter your current location: ");
                  Scanner keyboard = new Scanner(System.in);
                  String location = keyboard.nextLine();
                  return location;
          }

        // Gets and returns destination
        public String getDestination() {
                  System.out.print("Enter your desired destination: ");
                  Scanner keyboard = new Scanner(System.in);
                  String destination = keyboard.nextLine();
                  return destination;
        }



}
