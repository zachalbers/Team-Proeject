/*
This class takes in a hashmap of the buildings of the selected map text file.
The public 'pathfind' method takes in the location and destiantion and returns a list of the the buildings from the location to the destination.
The public 'getDistanceStr' method returns the distance of the route as String.
*/


package unimap.programlogic;
import java.util.ArrayList;
import java.lang.Object;
import java.util.*;


public class Pathfinder {

private java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
private List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
private double finalDistance;


public Pathfinder(HashMap<String,BuildingStructure> buildings) {
	this.buildings = buildings;
}


// This method will iterate through each building's connections from the location to
// the destination to find the shortest distance.
// If a path leads to a dead end, it will backtrack until a path is found.
public List<String> pathfind(String locationString, String destinationString) {
	pathList.clear(); // Clears any previous buidlings from previous uses.

    finalDistance = 0;
    BuildingStructure location = buildings.get(locationString);
    BuildingStructure destination = buildings.get(destinationString);

    BuildingStructure currentBuilding = location; // The current building on the path from which the next building will be determined.
	BuildingStructure neighborObj = location; // The current connection of 'currentBuilding' that will have its distance calcutlated.
    BuildingStructure bestBuilding = location; // The 'neighborObj' with the shortest distance to the destination.

    List<String>  closedPaths= Collections.synchronizedList(new ArrayList<String>()); // Contain buildings that have already been travelled on.

    pathList.add(location.getBuildingName());
    closedPaths.add(location.getBuildingName());

	try {
		// The loop will continue to iterate until the name of the current building equals the destination.
	    while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
	        String changeCheck = bestBuilding.getBuildingName();
	        double bestDistance = 100000;     // Infinity

	        for (String neighbor : currentBuilding.getConnections() ) {
	            neighborObj = buildings.get(neighbor);
	            double currentDistance = getDistance(neighborObj, destination);

	            if (closedPaths.contains(neighborObj.getBuildingName())) {
	                continue;
	            } else if (currentDistance < bestDistance) {
	                bestDistance = currentDistance;
	                bestBuilding = neighborObj;
	            }
	        }

	        // If the building hasn't changed, then the path will go back a building.
	        if (changeCheck.equals(bestBuilding.getBuildingName())) {
	            closedPaths.add(currentBuilding.getBuildingName());
	            pathList.remove(pathList.size()-1);
	            currentBuilding = buildings.get(pathList.get(pathList.size()-1));

	        // Otherwise, it will add the closest building to the path list.
	        } else {
	            pathList.add(bestBuilding.getBuildingName());
	            closedPaths.add(bestBuilding.getBuildingName());
	            currentBuilding = bestBuilding;
	        }
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Error: Cannot find connection at building " + currentBuilding.getBuildingName() );
		System.exit(0);
	} catch (NullPointerException e) {
		System.out.println("Error: Cannot find connection at building " + currentBuilding.getBuildingName() );
		System.exit(0);
	}

    return pathList;
}

// Calculate the distance between two building objects.
private double getDistance(BuildingStructure currentB, BuildingStructure nextB) {
    double x1 = currentB.getX();
    double x2 = nextB.getX();
    double y1 = currentB.getY();
    double y2 = nextB.getY();
    double difX = Math.pow( (x1 - x2), 2.0);
    double difY = Math.pow( (y1 - y2), 2.0);
    return Math.sqrt( (difX + difY) );
}


// Calculates the time the user takes depending on the travel method they select and returns the time as a String.
public String getDistanceStr(String travelMethod){


	//The distance from the start position to the final destintaion.
	for (int i =0; i<(pathList.size() - 1); i++) {
		finalDistance += getDistance(buildings.get(pathList.get(i)), buildings.get(pathList.get(i+1)) );
	}


	int minutes;
	int seconds;
	String time;
	switch (travelMethod) {
		case "Walk" : seconds = (int)(finalDistance / 1.4);
					break;
		case "Run" : seconds = (int)(finalDistance / 2.69);
					break;
		case "Skate" : seconds = (int)(finalDistance / 3.2);
					break;
		case "Bike" : seconds = (int)(finalDistance / 4.29);
					break;
		default : seconds = 0;
	}
	minutes = seconds / 60;
	seconds = seconds % 60;
	time = travelMethod + " time: " + Integer.toString(minutes) + " min " + Integer.toString(seconds) + " sec";
	return time;
}







}
