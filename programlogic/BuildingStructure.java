/*
This class creates the structure for a building.
The methods allow properties of the building to be set as well as returned.

*/

package unimap.programlogic;
import java.util.*;


public class BuildingStructure {

private int height = 0;
private int length = 0;
private double xCoord = 0;
private double yCoord = 0;
private String buildingName = "";
private String abbreviation = "";
private String[] connections = {};


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

// sets x for building location on map
public void setX(String xCoord) {
    this.xCoord = Double.parseDouble(xCoord);
}

// sets y for building location on map
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

// Give building obj a name to be referenced for input
public void setBuildingName(String name) {
    buildingName = name;
}

// returns name of building
public String getBuildingName() {
    return buildingName;
}

// sets building connections
public void setConnections(String newConnections) {
    connections = newConnections.split("/");
}

// return connections
public String[] getConnections() {
    return connections;
}

// returns length
public int getLength(){
    return length;
}

// sets height
public void setLength(String length){
    this.length = Integer.parseInt(length);
}
// returns height
public int getHeight(){
    return height;
}
// sets height
public void setHeight(String height){
    this.height = Integer.parseInt(height);
}

// returns abbreviation
public String getAbbreviation(){
    return abbreviation;
}
// sets abbreviation
public void setAbbreviation(String abbreviation){
    this.abbreviation = abbreviation;
}


}
