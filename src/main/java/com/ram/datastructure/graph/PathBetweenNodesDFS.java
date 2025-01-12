package com.ram.datastructure.graph;

import java.util.*;

public class PathBetweenNodesDFS {

    public static void main(String[] args) {
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        //int[][] edges =  {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath(10,edges,7, 5));

    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];
        if(edges.length == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            //System.out.println(Arrays.toString(edge));
            int u = edge[0];
            int v = edge[1];
            //System.out.println(adjList);
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }
        System.out.println(graph);
        return helper(graph, source, destination, visited);
    }

    public static boolean helper(HashMap<Integer,List<Integer>> adjList, int source, int destination,int[] visited) {

        if(source == destination) {
            return true;
        }
        visited[source] = 1;
        for (Integer neighbor : adjList.getOrDefault(source,new ArrayList<>())) {
            if (visited[neighbor] != 1) {
                //System.out.println("Traversing through: " + neighbor);
                if(helper(adjList, neighbor, destination, visited)) {
                    return true;
                }
            } else {
                //System.out.println(neighbor + " has already been visited");
            }
        }
        return false;
    }
}
