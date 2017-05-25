import java.util.ArrayList;

import java.lang.Object;
import java.util.*;

// This is the main class that is run.
// Currently it also contains the pathfinding alogrithm and the distance calculator.

public class Team {

public static void main(String[] args) {

        // // Calls GUI class
        // ComboBoxExample UserGUI = new ComboBoxExample();
        // UserGUI.main(args);


        // Getting User input
        Travel nextTravel = new Travel();
        String location = nextTravel.getLocation();
        String destination = nextTravel.getDestination();


        Building locationObj = AllBuildings.buildings(location);
        Building destinationObj = AllBuildings.buildings(destination);



        some(locationObj, destinationObj);



        }


        public static void some(Building location, Building destination) {
                  List<String> haveTravelled = Collections.synchronizedList(new ArrayList<String>());



                  Building currentBuilding = location;
                  Building bestBuilding = location;
                  double bestDistance = getDistance(location, destination);

                  while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
                            boolean first = true;
                            for (String neighbor : currentBuilding.getConnections() ) {
                                    Building neighborObj = AllBuildings.buildings(neighbor);

                                    double currentDistance = getDistance(neighborObj, destination);

                                    if (haveTravelled.contains(neighborObj.getBuildingName())) {
                                      continue;
                                    } else if (first) {
                                      bestDistance = currentDistance;
                                      bestBuilding = neighborObj;
                                      first = false;
                                    } else if (currentDistance < bestDistance) {
                                                bestDistance = currentDistance;
                                                bestBuilding = neighborObj;
                                    }

                            }
                            System.out.println("Go to " + bestBuilding.getBuildingName());
                            haveTravelled.add(bestBuilding.getBuildingName());
                            currentBuilding = bestBuilding;






                  }


        }

        public static double getDistance(Building currentB, Building nextB) {
                double x1 = currentB.getX();
                double x2 = nextB.getX();
                double y1 = currentB.getY();
                double y2 = nextB.getY();

                double difX = Math.pow( (x1 - x2), 2.0);
                double difY = Math.pow( (y1 - y2), 2.0);

                return Math.sqrt( (difX + difY) );
        }

}






















// // Calls the pathfinder method
// path(locationObj, destinationObj, direction);






// // Temporary pathfinding method.
// // Takes in the location, destination, and direction.
// public static void path(Building loc, Building dest, String dir) {
//         Building currentBuilding = loc;
//
//         // The loop will end once it has reached the destination building.
//         while ( !currentBuilding.getBuildingName().equals(dest.getBuildingName()) ) {
//
//                 // The for in loop goes through each connection of the building and checks to see which
//                 // one is closer to the destination.
//                 for (String nextLocation : currentBuilding.getConnections() ) {
//                         Building nextBuilding = AllBuildings.buildings(nextLocation);
//                         if (dir == "West") {
//                                 if (nextBuilding.getX() > currentBuilding.getX() ) {
//                                         System.out.println("Go to " + nextBuilding.getBuildingName());
//                                         currentBuilding = nextBuilding;
//                                 }
//                         } else {
//                                 if (nextBuilding.getX() < currentBuilding.getX() ) {
//                                           System.out.println("Go to " + nextBuilding.getBuildingName());
//                                           currentBuilding = nextBuilding;
//                                         }
//                                 }
//                         }
//                 }
//         }
