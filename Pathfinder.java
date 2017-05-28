import java.util.ArrayList;

import java.lang.Object;
import java.util.*;


public class Pathfinder {
  List<String> haveTravelled = Collections.synchronizedList(new ArrayList<String>());
  String nameString = "";

  public void pathfind(Building location, Building destination, AllBuildings nextBuilding) {




            Building currentBuilding = location;
            Building bestBuilding = location;
            double bestDistance = getDistance(location, destination);

            while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
                      boolean first = true;
                      for (String neighbor : currentBuilding.getConnections() ) {
                              Building neighborObj = nextBuilding.buildings(neighbor);

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
                      haveTravelled.add(bestBuilding.getBuildingName());
                      currentBuilding = bestBuilding;

            }


            for (String name : haveTravelled) {
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
