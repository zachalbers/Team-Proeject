import java.util.Arrays;

//This class creates the structure for a building.
//The methods allow properties of the building to be set as well as returned.

public class Building {

    double xCoord = 0;
    double yCoord = 0;
    String buildingName = "";
    String[] connections = {};

    public void setCoordinates(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
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
