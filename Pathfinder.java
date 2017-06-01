import java.util.ArrayList;

import java.lang.Object;
import java.util.*;

public class Pathfinder {

  String nameString = "";

  public void pathfind(String locationString, String destinationString) {

          AllBuildings BuildingFiles = new AllBuildings();

          Building location = BuildingFiles.buildings(locationString);
          Building destination = BuildingFiles.buildings(destinationString);

          Building neighborObj = new Building();

          Building currentBuilding = location;
          Building bestBuilding = location;

          // Contains the final list of buildings from the location to the destination.
          List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
          // Contain buildings that have already been travelled on.
          List<String>  closedPaths= Collections.synchronizedList(new ArrayList<String>());

          pathList.add(location.getBuildingName());
          closedPaths.add(location.getBuildingName());

          while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
                    String changeCheck = bestBuilding.getBuildingName();
                    double bestDistance = 100000; // Infinity

                    for (String neighbor : currentBuilding.getConnections() ) {
                            neighborObj = BuildingFiles.buildings(neighbor);
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
                            currentBuilding = BuildingFiles.buildings(pathList.get(pathList.size()-1));

                    // Otherwise, it will add the closest building to the path list.
                    } else {
                            pathList.add(bestBuilding.getBuildingName());
                            closedPaths.add(bestBuilding.getBuildingName());
                            currentBuilding = bestBuilding;
                    }
          }

          // Creates a String with all the building names in the path.
          for (String name : pathList) {
                  nameString += "Got to: " + name + ",";
          }
          System.out.println(nameString);
  }

  // Calculate the distance between two building objects.
  public double getDistance(Building currentB, Building nextB) {
          double x1 = currentB.getX();
          double x2 = nextB.getX();
          double y1 = currentB.getY();
          double y2 = nextB.getY();

          double difX = Math.pow( (x1 - x2), 2.0);
          double difY = Math.pow( (y1 - y2), 2.0);

          return Math.sqrt( (difX + difY) );
  }

}
