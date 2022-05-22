package trip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import trip.*;

public class Graph {
	//LOCATION DETAILS
	class Location {
		int idx;
		int pinno;
		String city;
		String state;
		LinkedList<Location> connectedLocation = new LinkedList<>();

		Location(int i, String city, String state) {
			idx = i;
			this.city = city;
			this.state = state;
		}
	}
	Scanner scn = new Scanner(System.in);

	List<Location> lcn = new ArrayList<>();

	//Backend b = new Backend();
	Node[] head;
	int n, e, size = 0;
	int graph[][];
	int src, dest, total_cost, dist;
	List<Integer> cl = new ArrayList<Integer>();
	List<Integer> all = new ArrayList<Integer>();
	ArrayList<Integer> path = new ArrayList<Integer>();
	//List<Integer> parent = new ArrayList<Integer>(25);

	int parent[] = new int[26];
	public Graph(int n) {
		this.n = n;
		graph = new int[n][n];
		head = new Node[n];
	}

	//METHOD TO ADD ROUTE BETWEEN TWO CITIES
	void addEdge(int u, int v, int w) {
		Node new_node = new Node(v, w);
		if (head[u] == null) {
			head[u] = new_node;
			return;

		}
		Node temp = head[u];
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new_node;
	}

	//BFS METHOD OF TRAVERSING CITIES
	void BFS_List(int v) {

		Node ptr;
		int visited[] = new int[n];
		int flag = 0;
		for (int i = 1; i < n; i++) {
			visited[i] = 0;
		}
		
		visited[v] = 1; // mark visited vertex to 1
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v); // add vertex in queue
		while (!q.isEmpty()) {
			v = q.remove(); // remove vertex
			cl.add(v);
			while (flag <= 1) {//TO GET FIRST LAYER OF NEIGHBOURING CITIES
				if (head[v] != null) {
					ptr = head[v];
					while (ptr != null) {
						if (visited[(ptr.dest)] == 0) {
							q.add((ptr.dest));
							visited[(ptr.dest)] = 1;
							flag++;
						}
						ptr = ptr.next;
						
					}
					

				}
			}
		}
	}
	
	void display(int v) {

		Node ptr;
		int visited[] = new int[n];
		for (int i = 1; i < n; i++) {
			visited[i] = 0;
		}
		visited[v] = 1; // mark visited vertex to 1
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v); // add vertex in queue
		while (!q.isEmpty()) {
			v = q.remove(); // remove vertex
			all.add(v);
				if (head[v] != null) {
					ptr = head[v];
					while (ptr != null) {
						if (visited[(ptr.dest)] == 0) {
							q.add((ptr.dest));
							visited[(ptr.dest)] = 1;
						}
						ptr = ptr.next;
						
					}
				}
			}
		}
	
	//ADDING ROUTE BETWEEN TWO CITIES INTO MAP
	void addRoute(int c1, int c2, int w) {
		
		graph[c1][c2] = w;
		graph[c2][c1] = w;
		addEdge(c1, c2, w);

	}
	

	
	private static final int NO_PARENT = -1;
	 
    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    public void dijkstras(int[][] adjacencyMatrix, int startVertex,int d)
    {
        int nVertices = 26;
 
        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];
 
        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];
 
        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
                                            vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;
 
        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];
 
        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;
 
        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] <
                    shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0
                    && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                                                       edgeDistance;
                }
            }
        }
 
       printSolution(startVertex, shortestDistances, parents,d);
        
    }
	
    
    
    
    
	private void printSolution(int startVertex, int[] distances, int[] parents,int d) {
		// TODO Auto-generated method stub
		int nVertices = distances.length;
//        System.out.print("Index\t Distance\tPath");
         
        for (int vertexIndex = 1;
                 vertexIndex < nVertices;
                 vertexIndex++)
        {
            if (vertexIndex != startVertex && vertexIndex==d)
            {
//                System.out.print("\n\t\t\t\t" + (startVertex) + " -> ");
//                System.out.print((vertexIndex) + " \t\t ");
//                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
	}

	public void printPath(int currentVertex, int[] parents) {

// Base case : Source node has
// been processed
		if (currentVertex == NO_PARENT) {
			return;
		}
		printPath(parents[currentVertex], parents);
		
		//System.out.print(b.getcity(currentVertex) + " ");
		path.add(currentVertex);
	}
	
	private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
		int minDistance = Integer.MAX_VALUE;
		int minDistanceVertex = 0;
		for (int i = 0; i < distance.length; i++) {
			if (!visitedVertex[i] && distance[i] < minDistance) {
				minDistance = distance[i];
				minDistanceVertex = i;
			}
		}
		return minDistanceVertex;
	}
//DJIKSTRA ALGORITHM TO GET SHORTEST PATH
	public void dijkstra(int[][] graph, int source, int dest) {
		int count = graph.length;
		boolean[] visitedVertex = new boolean[count];
		int[] distance = new int[count];
		for (int i = 0; i < count; i++) {
			visitedVertex[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}

		// Distance of self loop is zero
		distance[source] = 0;
		for (int i = 0; i < count; i++) {

			// Update the distance between neighboring vertex and source vertex
			int u = findMinDistance(distance, visitedVertex);
			visitedVertex[u] = true;
			
			// Update all the neighboring vertex distances
			for (int v = 0; v < count; v++) {
				if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
					parent[v] = u;
					distance[v] = distance[u] + graph[u][v];
				}
			}
			
		}
		for (int i = 1; i <= 25; i++) {
			if (i == dest) {
				total_cost = distance[i] * 2;
				src = source;
				dest = i;
				dist = distance[i];
			}
		}

	}

}
