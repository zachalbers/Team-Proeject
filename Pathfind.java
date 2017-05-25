import java.lang.Math;
import java.util.Arrays;


public class Pathfind {


          public void some(Building location, Building destination) {
                    // List<String> pathSet = new ArrayList<String>();


                    Building currentBuilding = location;

                    while ( !currentBuilding.getBuildingName().equals(dest.getBuildingName()) ) {
                              Building bestBuilding = currentBuilding;
                              double bestDistance = getDistance(location, destination);
                              for (String neighbor : currentBuilding.getConnections() ) {
                                      Building neighborObj = AllBuildings.buildings(neighbor);

                                      double currentDistance = getDistance(neighborObj, destination);

                                      if (currentDistance < bestDistance) {
                                                bestDistance = currentDistance;
                                                bestBuilding = neighborObj;
                                      }


                              }
                              System.out.println("Go to " + bestBuilding.getBuildingName());
                              currentBuilding = bestBuilding;






                    }


          }

          public double getDistance(Building currentB, Building nextB) {
                  double x1 = currentB.getX()
                  double x2 = nextB.getX();
                  double y1 = currentB.getY();
                  double y2 = nextB.getY();

                  double difX = Math.pow( (x1 - x2), 2.0);
                  double difY = Math.pow( (y1 - y2), 2.0);

                  return Math.sqrt( (difX + difY) );
          }




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
