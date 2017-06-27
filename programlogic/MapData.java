/*
This class takes in the name of the txt file and reads in the buildings from the file and saves them to a HashMap of buildings.
It also reads in the settings (colors and map legend) for that particular map and saves them to the 'settings' list.
*/

package unimap.programlogic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class MapData {

public java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
public java.util.List<String[]> settings = Collections.synchronizedList(new ArrayList<String[]>());
private String mapName;

// Constructor that takes in the name of the file to read and reads the file.
public MapData(String mapName) {
  this.mapName = mapName;
  readFile();
}


public void readFile() {
    java.util.List<String> cb = Collections.synchronizedList(new ArrayList<String>());
    boolean readingSettings = false;
    String line;
	int lineCount = 0;

    try {
        FileReader reader = new FileReader("./unimap/Map-Files/" + mapName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Will read every line until the end of the file is reached
        while ((line = bufferedReader.readLine()) != null) {
			lineCount++;
            // Blank lines and comments will be skipped.
            if ( line.startsWith("//") || (line.equals("")) ) {
                continue;
            }

            // Once all the builings have been read in, it start adding settings and icon locations.
            if (line.equals("END_OF_All_BUILDINGS")) {
              readingSettings = true;
              continue;
            }
            if (readingSettings) {
                String[] currentLine = line.split(" ");
                settings.add(currentLine);
            }

            // Creates all of the building objects.
            if (line.equals("END_OF_BUILDING")) {
				if (cb.size() != 7) {
					throw new Exception("Wrong length of parameters for buildings in " + mapName);
				}

				String name = cb.get(0);
                buildings.put(name, new BuildingStructure(cb.get(0),cb.get(1),cb.get(2),cb.get(3),cb.get(4),cb.get(5),cb.get(6)) );
                cb.clear();
            } else {
                cb.add(line);
            }

        }
        reader.close();

		if (buildings.size() == 0) {
			throw new Exception("Incorrect Format. No buildings found in " + mapName);
		}
		if (settings.size() < 4) {
			throw new Exception("Incorrect Format. Not enough setting parameters in " + mapName);
		}

    } catch (IOException e) {
		System.out.println("Error: "+ e.getMessage() +" at line " + lineCount);
		System.exit(0);
    } catch (Exception e) {
		System.out.println("Error: "+ e.getMessage() +" at line " + lineCount);
		System.exit(0);

	}

}







}
