import java.util.ArrayList;

import java.lang.Object;
import java.util.*;


public class Pathfinder {


  String nameString = "";

  public void pathfind(Building location, Building destination, AllBuildings nextBuilding) {

          List<String> pathList = Collections.synchronizedList(new ArrayList<String>());
          List<String>  closedPaths= Collections.synchronizedList(new ArrayList<String>());

          pathList.add(location.getBuildingName());
          closedPaths.add(location.getBuildingName());

          Building neighborObj = new Building();
          Building currentBuilding = location;
          Building bestBuilding = location;



          while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
                    String changeCheck = bestBuilding.getBuildingName();
                    double bestDistance = 100000;

                    for (String neighbor : currentBuilding.getConnections() ) {
                            neighborObj = nextBuilding.buildings(neighbor);
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
                            closedPaths.add(neighborObj.getBuildingName());
                            pathList.remove(pathList.size()-1);
                            currentBuilding = nextBuilding.buildings(pathList.get(pathList.size()-1));

                    // Otherwise, it will add the closest building to the path list.
                    } else {
                            pathList.add(bestBuilding.getBuildingName());
                            closedPaths.add(bestBuilding.getBuildingName());
                            currentBuilding = bestBuilding;
                    }
          }

          for (String name : pathList) {
                  nameString += "Got to: " + name + ",";
          }
          System.out.println(nameString);

  }

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
