package trip;
public class Node {//LOCATION DETAILS
	int dest;
	int wt;
	Node next;

	Node(int dest, int wt) {
		this.dest = dest;//END LOCATION
		this.wt = wt;//DISTANCE
		next = null;
	}
}

