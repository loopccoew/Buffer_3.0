package com.example.cumminsnavigator;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

/**
 * 0: Comp and E&TC
 * 1: IT
 * 2: Mech
 * 3: MBA
 * 4: Canteen
 * 5: Instru 1 ie near main gate
 * 6: Instru 2 ie near canteen
 * 7: Mechatronics
 * 8: Main Gate
 * 9: Back Gate to lane 1
 * 10: Back gate to lane 2
 */

public class map {

    // graph class/driver class

    int n = 11;
    ArrayList<ArrayList<node>> graph = new ArrayList<>(11); // adjacency list

    public void display() {

        for (int i = 0; i < 11; i++) {
            System.out.print(i);
            for (int j = 0; j < graph.get(i).size(); j++)
                System.out.print("  -" + graph.get(i).get(j).weight + "->  " + graph.get(i).get(j).vertex);
            System.out.println();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String dijkstra(int source, int target) {
        int distance[] = new int[11];
        int prev[] = new int[11]; // stores the node previously visited

        for (int i = 0; i < 11; i++) {
            distance[i] = Integer.MAX_VALUE;// setting initial distances to infinity
            prev[i] = Integer.MIN_VALUE;
        }

        PriorityQueue<node> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight); // priority queue
        // that adds elements
        // based on weights
        distance[source] = 0;
        pq.add(new node(source, 0));// adding source node

        while (pq.size() > 0) {
            node current = pq.poll();
            for (node n : graph.get(current.vertex))
            {
                if (distance[current.vertex] + n.weight < distance[n.vertex]) // dijkstra condition
                {
                    distance[n.vertex] = n.weight + distance[current.vertex];
                    pq.add(new node(n.vertex, distance[n.vertex])); // replacing distances
                    prev[n.vertex] = current.vertex;
                }
            }
        }

        String printPath = path(prev, source, target);
        return  printPath;
    }

    public String path(int[] prev, int source, int target) {
        // on following the prev[] array from target vertex until we reach the source
        // vertex, we get the path
        /**
         * we add the target vertex to the stack, then we check the previously visited
         * vertex of target
         * we add that vertex to the stack and check its previously visited vertex
         * we keep going until we reach the source
         */
        String printPath = "";
        Stack<Integer> s = new Stack<>();
        s.push(target);
        while (target != source) {
            target = prev[target];
            s.push(target);
        }
        while (!s.isEmpty()) {
            int ele = s.pop();
            printPath = printPath + graph.get(ele).get(0).name + "-->\n";

        }
        printPath = printPath + "Destination Reached";
        return printPath;
    }
}


