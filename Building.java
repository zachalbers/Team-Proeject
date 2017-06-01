import java.util.Arrays;

//This class creates the structure for a building.
//The methods allow properties of the building to be set as well as returned.

public class Building {

    int width = 0;
    int length = 0;
    double xCoord = 0;
    double yCoord = 0;
    String buildingName = "";
    String abbreviation = "";
    String[] connections = {};

// sets x,y for building location on map
    public void setCoordinates(double x, double y) {
        xCoord = x;
        yCoord = y;
    }
// return x coordinate of building
    public double getX() {
        return xCoord;
    }
// return y coordinate of building
    public double getY() {
        return yCoord;
    }
// Give building obj a name to be referanced for input
    public void setBuildingName(String name) {
        buildingName = name;
    }
// return name of building
    public String getBuildingName() {
        return buildingName;
    }

// sets building connections for pathfinder
    public void setConnections(String newConnections) {
        connections = newConnections.split(",");
    }

// return connections for pathfinder
    public String[] getConnections() {
        return connections;
    }

// return Building hight for map
    public int getLength(){
        return length;
    }

// sets Height for map
    public void setLength(int l){
        length=l;
    }
// return Building width for map
    public int getWidth(){
        return width;
    }
// sets width for map
    public void setWidth(int w){
        width=w;
    }
// return abbreviation for building
    public String getAbbreviation(){
        return abbreviation;
    }
// sets abbreviations for building objects
    public void setAbbreviation(String abbr){
      abbreviation = abbr;
    }

}
