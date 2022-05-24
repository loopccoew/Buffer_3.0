package com.example.cumminsnavigator;

import java.util.ArrayList;

// node class
public class node {
    int vertex;
    int weight;
    String name;

    ArrayList<ArrayList<String>> rooms = new ArrayList<>(6);

    node(int v, int w) {
        vertex = v;
        weight = w;
        for (int i = 0; i < 6; i++)
            rooms.add(new ArrayList<String>());
    }

}// end of node class

