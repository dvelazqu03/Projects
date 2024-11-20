/*
	Diego Velazquez
	32101041
*/

import java.util.LinkedList;
public class Node implements Comparable<Node> {
	String inter_ID;
	double length;
	double X, Y;
	boolean known;
	LinkedList<Edge> roadList;
	public Node previous;
	
	//reading "i" lines as latitude and longitude
	public Node(String inter_ID, double X, double Y) {
		this.inter_ID = inter_ID;
		this.X = X;
		this.Y = Y;
		roadList = new LinkedList<>();
		this.known = false;
	}
	
	//checking redundance within nodes IDs
	public boolean isEqual(Node node) {
		if(inter_ID.equals(node.inter_ID)) {
			return(X == node.X ) && (Y == node.Y);
		}

		return false;
	}
	
	//return distance
	public double length() {
		return this.length;
	}
	
	//sets distance
	public void setLength(double length) {
		this.length = length;
	}
	
	//set current node as previous to current
	public void setPrevious(Node node) {
		this.previous = node;
	}
	
	//confirm it has been discovered
	public void known() {
		this.known = true;
	}
	
	//confirm it has not yet been discovered
	public void unknown() {
		this.known = false;
	}
	
	//check is known
	public boolean discovered() {
		return this.known;
	}
	
	//get the total path
	public LinkedList<Node> getPath(){
		LinkedList<Node> disc = new LinkedList<>();
		Node current = this;
		while(current!= null) {
			disc.add(current);
			current = current.previous;
		}

		return disc;
	}

	@Override
	public int compareTo(Node node) {
		if (this.length < node.length) {
			return -1;

		} else if (this.length > node.length) {
			return 1;

		} else {
			return 0;
		}
	}
}
