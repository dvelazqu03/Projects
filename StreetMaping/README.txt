
Diego Velazquez
April 30, 2023

Intro:
This project will require you to create a rudimentary mapping program in Java. Given a data set representing the roads and intersections in a specific geographic region, your program should be able to plot a map of the data and provide shortest path directions between any two arbitrary intersections

This Project include the Graph, Edge and Node classes as well as other classes and the test files.

The "src" subdirectory includes the following files:

	Dijkstra.java - Implements Dijkstra's algorithm in order to identify and return the shortest path between two given intersections (IDs).
	
	Kruskal.java - Implements Kruskal's algorithm in order to process and return the Minimum Weight Spanning Tree.
	
	Node.java - Includes commented methods with the purpose of processing the Intersections from the input file.

	Edge.java - Includes commented methods with the purpose of processing the Roads or paths between two intersections from the input file.

	Graph.java - Processes the data from the input file and implements commented methods for classifying the data.

	MapDraw.java - implements proper scaling in order to display the GUI Map.

	Main.java - implements the main class for testing, and correctly identifies the command line inputs for SP or MeridianMap testing. 

	/!\ Each execution will display the map of the desired file (ur.txt, monroe.txt, nays.txt) with the correct name in the JFrame window and with possibility of resizing. The shortest path will be colored in RED and the Minimum Weight Spanning Tree paths will be colored in BLUE.
	
	/!\ Please refer to the OUTPUT.txt file for instructions on how to execute the program using the command-line. Using the IDE for testing is possible, and code has been highlighted and provided for that purpose; you will need to uncomment the bottom portion and comment the top portion of the Main.java class. 

	/!\ Please note that -- for Meridianmap testing -- the maps and minimum weight spanning trees for "monroe.txt" and "nys.txt" take some time to precess: ~5 Minutes for Monroe and ~1 hour for NYS. You can refer to the OUTPUT>txt file for information about the expected results for monroe.txt.

			-- Time Complexity --

	Dijkstra --  Executes with maximum complexity of O(ElogV)

	Kruskal -- Executes with maximum complexity of O(ElogE)

	Node -- Executes with maximum complexity of O(nlogn)
	
	Edge -- Executes with maximum complexity of O(1)

	Graph -- Executes with maximum complexity of O(nlogn)

	MapDraw -- Executes with maximum complexity of O(n^2)

	Main -- Executes with maximum complexity of O(1)



