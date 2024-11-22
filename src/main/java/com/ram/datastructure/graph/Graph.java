package com.ram.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public boolean addEdge(String a, String b) {
        if(adjacencyList.containsKey(a)) {
            adjacencyList.get(a).add(b);
            return true;
        } else {
            System.out.println(a + " is not a vertex in the Graph");
            return false;
        }
    }

    public void addVertex(String a) {
        adjacencyList.putIfAbsent(a, new ArrayList<>());
    }

    public void printGraph() {
        adjacencyList.entrySet().forEach(System.out::println);
    }
}
