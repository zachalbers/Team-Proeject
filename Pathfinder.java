import java.util.ArrayList;

import java.lang.Object;
import java.util.*;

public class Pathfinder {



public Pathfinder(HashMap<String,BuildingStructure> buildings) {
  this.buildings = buildings;
}


java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
List<String> pathList = Collections.synchronizedList(new ArrayList<String>());

public List<String> pathfind(String locationString, String destinationString) {

    double finalDistance = 0;





    BuildingStructure location = buildings.get(locationString);
    BuildingStructure destination = buildings.get(destinationString);

    BuildingStructure neighborObj = location;
    BuildingStructure currentBuilding = location;
    BuildingStructure bestBuilding = location;

    // Contains the final list of buildings from the location to the destination.
    pathList.clear();
    // Contain buildings that have already been travelled on.
    List<String>  closedPaths= Collections.synchronizedList(new ArrayList<String>());

    pathList.add(location.getBuildingName());
    closedPaths.add(location.getBuildingName());

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
        // For error checking:
        // System.out.println(currentBuilding.getBuildingName());
    }


    return pathList;
    // for (int i =0; i<(pathList.size() - 1); i++) {
    //     finalDistance += getDistance(buildings.buildings.get(pathList.get(i)), buildings.buildings.get(pathList.get(i+1)) );
    // }
}



// Calculate the distance between two building objects.
public double getDistance(BuildingStructure currentB, BuildingStructure nextB) {
    double x1 = currentB.getX();
    double x2 = nextB.getX();
    double y1 = currentB.getY();
    double y2 = nextB.getY();

    double difX = Math.pow( (x1 - x2), 2.0);
    double difY = Math.pow( (y1 - y2), 2.0);

    return Math.sqrt( (difX + difY) );
}

}
