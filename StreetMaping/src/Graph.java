/*
	Diego Velazquez
	32101041
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Graph {
	final int INFINITY = 1000000000;
	static int count=0;
	int vertexCount=0;
	int edgeCount=0;
	LinkedList<Node> List;
	HashMap<String, Node> Map;
	String mapFileName;
	String inter_ID;
	String road_ID;
	String inter_1, inter_2;
	int counter=0;
	int counter_1=0;
	double latitude, longitude;
	double maxLatitude=-INFINITY, minLatitude=INFINITY;
	double maxLongitude=-INFINITY, minLongitude=INFINITY;
	Node Intersection;
	Edge Road;
	
	//initialization
	public Graph() {
		Map = new HashMap<String, Node>();
		List = new LinkedList<Node>();
	}
	
	//read data from the file
	public Graph(String mapFileName) throws FileNotFoundException {
		// Reading the file
		Map = new HashMap<String, Node>();
		List = new LinkedList<Node>();
		this.mapFileName=mapFileName;
		File file = new File(mapFileName);
		Scanner scan = new Scanner(file);
		System.out.println("\n"+"Loading Data, please wait");
		
		//classifying file contents
		while(scan.hasNext()) {
			counter++;
			if(mapFileName.equals("ur.txt")) {
				if(counter==10) {
					counter=0;
					System.out.print(".");
				}
			} 
			else if(mapFileName.equals("monroe.txt")) {
				if(counter==5000) {
					counter=0;
					System.out.print(".");
				}
			} 
			else if(mapFileName.equals("nys.txt")) {
				if(counter==10000) {
					counter=0;
					System.out.print(".");
				}
			}

			//reading the tokens
			String line = scan.nextLine();
			String[] tokens = line.split("\b|\t");
			
			//identifying internsections
			if(tokens[0].equals("i")) {
				inter_ID = tokens[1];
				latitude = Double.parseDouble(tokens[2]);
				longitude = Double.parseDouble(tokens[3]);
				Intersection = new Node(inter_ID, latitude, longitude);
				Map.put(inter_ID, Intersection);
				List.add(Intersection);
				vertexCount++;
				if(maxLatitude <= latitude) {
					maxLatitude = latitude;
				}
				if(minLatitude >= latitude) {
					minLatitude = latitude;
				}
				if(maxLongitude <= longitude) {
					maxLongitude = longitude;
				}
				if(minLongitude >= longitude) {
					minLongitude = longitude;
				}
			}
			
			//identifying roads
			else if(tokens[0].equals("r")) {
				road_ID = tokens[1];
				inter_1 = tokens[2];
				inter_2 = tokens[3];
				Node interFrom = Map.get(inter_1);
				Node interTo = Map.get(inter_2);
				Road = new Edge(road_ID, interFrom, interTo);
				interFrom.roadList.add(Road);
				Road = new Edge(road_ID, interTo, interFrom);
				interTo.roadList.add(Road);
				edgeCount++;
			}
		} 
		
		System.out.println("\n"+"Success!" +"\n"); scan.close();
	}
	
	//adds a road to the list
	public void addEdge(Edge edge) {
		Node intersection_1 = edge.intersection_1;
		Node intersection_2 = edge.intersection_2;
		String intersection_1_ID = intersection_1.inter_ID;
		String intersection_2_ID = intersection_1.inter_ID;
		Node nbrhd_1 = Map.get(intersection_1_ID);
		if(nbrhd_1 != null) {
			intersection_1 = nbrhd_1;	
		}
		else {
			intersection_1 = new Node(intersection_1_ID,intersection_1.X, intersection_1.Y);
			Map.put(intersection_1_ID, intersection_1);
		}
		Node nbrhd_2 = Map.get(intersection_2_ID);
		if(nbrhd_2 != null) {
			intersection_2 = nbrhd_2;
		}
		else {
			intersection_2 = new Node(intersection_2_ID,intersection_2.X, intersection_2.Y);
			Map.put(intersection_2_ID, intersection_2);
		}
		edge = new Edge(edge.road_ID, intersection_1, intersection_2);
		intersection_1.roadList.add(edge);
		intersection_2.roadList.add(edge);
	}
	
	//gets the keys
	public Set<String> getKeys(){return Map.keySet();}
	
	//gets the ID
	public Node getID(String ID) {return Map.get(ID);}
	
	//returs all roads
	public LinkedList<Edge> allEdges(){
		LinkedList<Edge> edgeList = new LinkedList<>();
		System.out.println();
		System.out.println("\n"+"Processing, please wait");
		for(int i=0; i<vertexCount; i++) {
			for(Edge current: this.List.get(i).roadList) {
				counter_1++;
				if(mapFileName.equals("ur.txt")) {
					if(counter_1==5) {
						counter_1=0;
						System.out.print(".");
					}
				} else if(mapFileName.equals("monroe.txt")) {
					if(counter_1==5000) {
						counter_1=0;
						System.out.print(".");
					}
				} else if(mapFileName.equals("nys.txt")) {
					if(counter_1==10000) {
						counter_1=0;
						System.out.print(".");
					}
				}
				if(edgeList.contains(current)) {
					continue;
				}
				else {
					edgeList.add(current);
				}
			}
		} 
		
		System.out.println("\n"+"Done!"); return edgeList; 
	}
	
	//checks cycle
	public boolean interLinked(Node inter_1, Node inter_2) {
		if(inter_2.length < INFINITY) {return true;}
		else {return false;}
	}
}
