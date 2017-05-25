//This class creates the structure for a building.
//The methods allow properties of the building to be set as well as returned.

import java.util.Arrays;

public class Building {

    int xCoord = 0;
    int yCoord = 0;
    String buildingName = "";
    String[] connections = {};

    public void setCoordinates(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public void setBuildingName(String name) {
        buildingName = name;
    }

    public String getBuildingName() {
        return buildingName;
    }


    public void setConnections(String newConnections) {
        connections = newConnections.split(",");
    }


    public String[] getConnections() {
        return connections;


    }

}
