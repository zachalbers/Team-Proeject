// This is the main class that is run.
// Currently it also contains the pathfinding alogrithm and the distance calculator.


// Hi this is Zach editing
// Hi this is usman 

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



        // Calculating the distance and direction
        int distance = locationObj.getX() - destinationObj.getX();
        String direction = "East";

        if (locationObj.getX() < destinationObj.getX()) {
                direction = "West";
        }
        System.out.println("The distance between these locations is: " + distance + " " + direction);

        // Calls the pathfinder method
        path(locationObj, destinationObj, direction);

        }

// Temporary pathfinding method.
// Takes in the location, destination, and direction.
public static void path(Building loc, Building dest, String dir) {
        Building currentBuilding = loc;

        // The loop will end once it has reached the destination building.
        while ( !currentBuilding.getBuildingName().equals(dest.getBuildingName()) ) {

                // The for in loop goes through each connection of the building and checks to see which
                // one is closer to the destination.
                for (String nextLocation : currentBuilding.getConnections() ) {
                        Building nextBuilding = AllBuildings.buildings(nextLocation);
                        if (dir == "West") {
                                if (nextBuilding.getX() > currentBuilding.getX() ) {
                                        System.out.println("Go to " + nextBuilding.getBuildingName());
                                        currentBuilding = nextBuilding;
                                }
                        } else {
                                if (nextBuilding.getX() < currentBuilding.getX() ) {
                                          System.out.println("Go to " + nextBuilding.getBuildingName());
                                          currentBuilding = nextBuilding;
                                        }
                                }
                        }
                }
        }
}
