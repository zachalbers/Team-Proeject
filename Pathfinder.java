import java.util.ArrayList;

import java.lang.Object;
import java.util.*;


public class Pathfinder {

  List<Building> pathList = Collections.synchronizedList(new ArrayList<Building>());
  List<Building>  closedPaths= Collections.synchronizedList(new ArrayList<Building>());
  String nameString = "";

  public void pathfind(Building location, Building destination, AllBuildings nextBuilding) {


            Building currentBuilding = location;
            Building bestBuilding = location;
            Building neighborObj = location;
            double bestDistance = getDistance(location, destination);

            while ( !currentBuilding.getBuildingName().equals(destination.getBuildingName()) ) {
                      Building changeCheck = bestBuilding;
                      for (String neighbor : currentBuilding.getConnections() ) {
                              neighborObj = nextBuilding.buildings(neighbor);

                              double currentDistance = getDistance(neighborObj, destination);


                              if (closedPaths.contains(neighborObj)) {
                                continue;
                              }
                              if (currentDistance < bestDistance) {
                                      bestDistance = currentDistance;
                                      bestBuilding = neighborObj;
                              }

                      }
                      if (changeCheck == bestBuilding) {
                          closedPaths.add(neighborObj);
                          pathList.remove(pathList.size()-1);
                          currentBuilding = pathList.get(pathList.size()-1);

                      } else {

                      pathList.add(bestBuilding);
                      closedPaths.add(bestBuilding);
                      currentBuilding = bestBuilding;
                    }

            }


            for (Building obj : pathList) {
              nameString += "Got to: " + obj.getBuildingName() + ",";
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
