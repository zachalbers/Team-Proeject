I. Developper Info
-------------------
Group:8
Tutorial:03
Menmbers:1)Usman Khawar
	 2)Tristan Randall
	 3)Zachariah Albers
	 4)Mahir Shahriar


II. Design
-----------
A. Purpose of UniMap & Functionality

1. UniMaP was originally designed to give a map of the Univercity of Calgary(hence the name), but has been modified to take in a text configuration file of the deired place a user would want to map.  The user is responsable for providing thier own text configuration files with the exception of the defaults provided in section III.

2.  UniMap will desplay a map(based on the text file selected by the user) along with a path from the user's current selected building to thier destination building.  If the user has decided to add a legend then the time requiered by either walking, running, skateboarding, or bikeing will also be displayed along with icons.

B. Package and class design

Note: Although multiple packages are not needed for the scope of this project we included two, grouping the classes as logically as possible so as to meet project requierments. 
 
1.userinterface: The userinerface package contains the GUI(main class), and MapWindow classes.

GUI:
MapWindow:   

2.programlogic: The programlogic package contains BuildingStructure, MapData, and Pathfinder.

BuildingStructure:
MapData:
Pathfinder:


III. Running the program
-------------------------
Note: UniMap has been tested to run on MacOS, Linux, and Windows

Steps.

1. Download the Zip file from Group 8's D2L dropbox 
2. Extract the Zip file
3. Open Terminal
4. Navigate to your extracted file's directory 
5. To compile type javac unimap/**/*.java in Terminal
6. To run type java unimap.userinterface.GUI in Terminal
0. Ask Mahir about the pathfinder(needed for pathfinder to be instanciated)Mahir's number:
403-334-5555, email: OMGSHAME@hotmail.com

