import java.util.*;

//This class creates the structure for a building.
//The methods allow properties of the building to be set as well as returned.

public class BuildingStructure {

    int height = 0;
    int length = 0;
    double xCoord = 0;
    double yCoord = 0;
    String buildingName = "";
    String abbreviation = "";
    String[] connections = {};


    public BuildingStructure(String buildingName, String abbreviation, String connections,
    String xCoord, String yCoord, String height, String length) {

        setBuildingName(buildingName);
        setAbbreviation(abbreviation);
        setConnections(connections);
        setX(xCoord);
        setY(yCoord);
        setHeight(height);
        setLength(length);
    }



// sets x,y for building location on map
    public void setX(String xCoord) {
      this.xCoord = Double.parseDouble(xCoord);
    }


    public void setY(String yCoord) {
      this.yCoord = Double.parseDouble(yCoord);
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
    public void setLength(String length){
        this.length = Integer.parseInt(length);
    }
// return Building width for map
    public int getHeight(){
        return height;
    }
// sets width for map
    public void setHeight(String height){
        this.height = Integer.parseInt(height);
    }
// return abbreviation for building
    public String getAbbreviation(){
        return abbreviation;
    }
// sets abbreviations for building objects
    public void setAbbreviation(String abbreviation){
      this.abbreviation = abbreviation;
    }




}
