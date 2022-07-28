
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;


class main{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<String> fav = new ArrayList<>();
		MapClass map = new MapClass();
		MapGraph g = map.MD();
		int ch=0;
		//Menu Driven Program
		do {
			System.out.println("\n-----------City-Route Tracker System------------ ");
			System.out.println("\n1. Display the adjacent cities of each city, the distance between and the time needed to reach them");
			System.out.println("2. Display the routes to adjacent cities of a particular city");
			System.out.println("3. Display the routes to all the cities from a particular city");
			System.out.println("4. Display the shortest path between two cities");
			System.out.println("5. Show your favourite places ");
			System.out.println("6. Exit.\nEnter your choice: ");
			ch=sc.nextInt();

			switch(ch) {

			case 1: g.display();break;
			case 2: System.out.println("Enter the city name: ");
			String city = sc.next();
			g.displayAllAdj(city);
			break;
			case 3: System.out.println("Enter the city name: ");
			String city1 = sc.next();
			g.displayAllRoutes(city1);
			break;
			case 4: System.out.println("Enter the starting city: ");
			String src = sc.next();
			System.out.println("Enter the destination city: ");
			String dest = sc.next();
			g.shortestPath(src, dest);
			int k =1;
			do {
				System.out.println("1.Add destination to your favourites ");
				System.out.println("2.Continue ");
				k = sc.nextInt();
				if(k==1) {
					fav.add(dest);
					break;
				}
				else {
					break;
				}
			}while(k!=2);
			break;
			case 5:
				System.out.println(fav);

				break;
			case 6: break;
			default: System.out.println("Wrong choice entered.");
			break;
			}
		}while(ch!=6);
		}
}

public class MapClass
{
	
	

	public MapGraph MD() {
		MapGraph g = new MapGraph();
		g.addEdge("Pune", "Mumbai", 148,172);
		g.addEdge("Pune", "Thane", 200, 184);
		g.addEdge("Pune", "Raigad", 136.6, 233);
		g.addEdge("Pune", "Ahmednagar", 125.5, 180);
		g.addEdge("Pune", "Satara", 112.4, 135);
		g.addEdge("Pune", "Solapur", 253.3, 274);
		g.addEdge("Nashik", "Ahmednagar", 156.7, 226);
		g.addEdge("Nashik", "Palghar", 147.4, 209);
		g.addEdge("Nashik", "Aurangabad", 197.1, 229);
		g.addEdge("Nashik", "Jalgaon", 249.7, 284);
		g.addEdge("Aurangabad", "Jalna", 59.1, 73);
		g.addEdge("Aurangabad", "Nashik", 197.1, 238);
		g.addEdge("Aurangabad", "Beed", 125.1, 131);
		g.addEdge("Aurangabad", "Jalgaon", 156.8, 252);
		g.addEdge("Aurangabad", "Buldhana", 137.5, 201);
		g.addEdge("Aurangabad", "Ahmednagar", 114, 135);
		g.addEdge("Mumbai", "Raigad", 167.6, 163);
		g.addEdge("Mumbai", "Palghar", 108.3, 158);
		g.addEdge("Palghar", "Ahmednagar", 286, 399);
		g.addEdge("Thane", "Palghar", 91.7, 122);
		g.addEdge("Thane", "Mumbai", 22.7, 36);
		g.addEdge("Thane", "Raigad", 108, 282);
		g.addEdge("Thane", "Ahmednagar", 231, 319);
		g.addEdge("Raigad", "Ratnagiri", 232, 331);
		g.addEdge("Ahmednagar", "Solapur", 275.7, 304);
		g.addEdge("Ahmednagar", "Beed", 128.2, 156);
		g.addEdge("Ratnagiri", "Satara", 191.7, 241);
		g.addEdge("Ratnagiri", "Kolhapur", 131.6, 197);
		g.addEdge("Satara", "Kolhapur", 121.9, 115);
		g.addEdge("Satara", "Sangli", 121.6, 129);
		g.addEdge("Satara", "Solapur", 235.4, 294);
		g.addEdge("Kolhapur", "Sangli", 46.7, 68);
		g.addEdge("Sangli", "Solapur", 187.6, 239);
		g.addEdge("Solapur", "Osmanabad", 67.8, 76);
		g.addEdge("Osmanabad", "Beed", 115.8, 116);
		g.addEdge("Osmanabad", "Latur", 72.5, 111);
		g.addEdge("Beed", "Latur", 135.9, 164);
		g.addEdge("Beed", "Parbhani", 147.4, 165);
		g.addEdge("Beed", "Jalna", 102.2, 114);
		g.addEdge("Latur", "Nanded", 137.4, 222);
		g.addEdge("Latur", "Parbhani", 130.2, 191);
		g.addEdge("Nanded", "Parbhani", 69.1, 115);
		g.addEdge("Nanded", "Buldhana", 243.3, 337);
		g.addEdge("Parbhani", "Jalna", 13.5, 202);
		g.addEdge("Parbhani", "Buldhana", 208.0, 295);
		g.addEdge("Jalna", "Buldhana", 112.8, 146);
		g.addEdge("Jalgaon", "Buldhana", 131.2, 172);

		return g;
	}
}

class Edge{

	//nbr = adjacent city
	String nbr;
	double distance;
	int time;
	//Constructor 
	Edge(String nbr,double distance){
		this.nbr=nbr;
		this.distance=distance;
	}
	Edge(String nbr,double distance,int time){
		this.nbr=nbr;
		this.distance=distance;
		this.time = time;
	}

}

class MapGraph{


	Scanner sc = new Scanner(System.in);

	//Map for storing Source as key and Edge as Value 
	Map<String, List<Edge>> map = new HashMap<>();



	//Adding edge in the map for source and destination vertex
	public void addEdge(String source,String destination,double distance, int time) {

		//if map doesn't contain source key, adding key and initialising it with new LinkedList of Edge
		if(!map.containsKey(source)) {
			map.put(source, new LinkedList<Edge>());
		}

		//if map doesn't contain destination key, adding key and initialising it with new LinkedList of Edge
		if(!map.containsKey(destination)) {
			map.put(destination, new LinkedList<Edge>());
		}

		//else adding the edge 
		map.get(source).add(new Edge(destination,distance,time));
		map.get(destination).add(new Edge(source,distance,time));




	}

	public void display() {

		//Iterating through map key-value pair
		for (Entry<String, List<Edge>> entry : map.entrySet()) {

			//Printing starting city 
			System.out.println("From "+entry.getKey()+" To  ");
			List<Edge> list = entry.getValue();

			//Traversing all the adjacent cities of the starting key city
			for(Edge i: list) {
				System.out.print("   "+i.nbr);
				System.out.print(" :: Distance:  "+i.distance+" km  ");

				System.out.print(":: Time Required : "+(i.time)/60+" hr "+(i.time)%60+" min ");
				System.out.println();
			}
			System.out.println();
		}
	}


	//Taking source from user and displaying all adjacent cities alongwith
	// distance and time 
	public ArrayList<String> displayAllAdj(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Place not found !");
			return null;
		}
		ArrayList<String> arr = new ArrayList<>();
		System.out.println("All direct routes from "+source+" are : ");
		List<Edge> list= map.get(source);
		for(Edge i: list) {
			String s = i.nbr+" =>  Distance : "+i.distance+"km   Time Required : "+(i.time)/60+" hr "+(i.time)%60+" min  ";
			arr.add(s);
			System.out.println("  "+i.nbr);
			System.out.println("  Distance: "+i.distance+" km ");
			System.out.print("  Time required:  "+(i.time)/60+" hr "+(i.time)%60+" min ");
			System.out.println("\n");
		}

		return arr;   

	}

	public void displayAllRoutes(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Place not found !");
			return;
		}
		System.out.println("All routes from "+source+" are : ");
		System.out.println();
		for(String i : map.keySet()) {
			shortestPath(source,i);
		}

	}




	public ArrayList<String> shortestPath(String src,String dest) {
		System.out.println("src is "+src+" dest is "+dest);

		ArrayList<String> p = new ArrayList<>();


		//if map doesn't contain source or destination city , printing the error message 
		if(!map.containsKey(src)||!map.containsKey(dest)) {
			System.out.println("Place not found !");
			return new ArrayList();
		}

		//Creating hashmap for storing current shortest distance to a particular city
		Map<String,Double> dist = new HashMap<>();
		//Creating hashmap for storing current time to a particular city
		Map<String,Integer> timeData = new HashMap<>();


		//Creating hashmap for storing parent of each node
		Map<String,String> route = new HashMap<>();
		route.put(src, src);

		//initially setting distance of each vertex to infinity (except source)
		for(String i:map.keySet()) {
			dist.put(i, Double.MAX_VALUE);
		}

		//Initial time of each vertex is 0 
		for(String i:map.keySet()) {
			timeData.put(i, 0);
		}

		dist.put(src, (double) 0);

		Queue<String> queue = new LinkedList<>();

		//Returning if source and destination are same 
		if(src==dest) {
			return new ArrayList<String>() ;
		}
		//Adding src to the queue
		queue.add(src);


		while(!queue.isEmpty()) {	

			String s = queue.poll();
			//Returning if source and destination are same
			if(s==dest) {
				break;
			}
			//Traversing through adjacent cities of s
			for(Edge edge: map.get(s)) {
				if(dist.get(s)+edge.distance<dist.get(edge.nbr)) {
					//Relaxation thm
					//If the  distance of the city is smaller than the current distnce , replacing it with smaller one
					dist.put(edge.nbr, dist.get(s)+edge.distance);
					//Updating time map simultaneously
					timeData.put(edge.nbr,timeData.get(s)+edge.time);

					route.put(edge.nbr, s);
					queue.add(edge.nbr);
				}
			}

		}

		//Printing path
		String str = dest;
		p.add(dest);
		String val = route.get(dest);
		while(val!=src) {
			str = val+" -> "+str;
			p.add(val);
			val = route.get(val);

		}

		String path = src+" -> "+str;
		p.add(src);
		String distance = dist.get(dest)+" km";
		String time = +timeData.get(dest)/60+" hr "+timeData.get(dest)%60+" min ";
		Collections.reverse(p);
		ArrayList<String> ar = new ArrayList<>();
		ar.add(path);
		ar.add(distance);
		ar.add(time);
		ar.addAll(p);

		System.out.println();	
		System.out.println(src+" -> "+str);
		System.out.println("Total Time required : "+timeData.get(dest)/60+" hr "+timeData.get(dest)%60+" min ");
		System.out.println("Total Distance : "+dist.get(dest)+" km");


		return ar;	
	}


}


