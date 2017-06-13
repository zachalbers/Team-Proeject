import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapData {

java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
java.util.List<String[]> settings = Collections.synchronizedList(new ArrayList<String[]>());

String mapName;

public MapData(String mapName) {
  this.mapName = mapName;
  readFile();
}


public void readFile() {
    java.util.List<String> cb = Collections.synchronizedList(new ArrayList<String>());
    boolean readingSettings = false;

    try {
        FileReader reader = new FileReader("./Map-Files/" + mapName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        // Current Building list.

        while ((line = bufferedReader.readLine()) != null) {

            if ( line.startsWith("//") || (line.equals("")) ) {
                continue;
            }


            if (line.equals("END_OF_All_BUILDINGS")) {
              readingSettings = true;
              continue;
            }
            if (readingSettings) {
                String[] currentLine = line.split(" ");
                settings.add(currentLine);
            }


            if (line.equals("END_OF_BUILDING")) {
                String name = cb.get(0);
                buildings.put(name, new BuildingStructure(cb.get(0),cb.get(1),cb.get(2),cb.get(3),cb.get(4),cb.get(5),cb.get(6)) );
                cb.clear();
            } else {
                cb.add(line);
            }

        }

        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
