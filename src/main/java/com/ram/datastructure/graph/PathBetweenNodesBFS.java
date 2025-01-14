package com.ram.datastructure.graph;

import java.util.*;

public class PathBetweenNodesBFS {

    public static void main(String[] args) {
        //int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int[][] edges =  {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath(10,edges,0, 1));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];
        if(edges.length == 0) {
            return true;
        }
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        System.out.println(graph);
        //return false;
        return helper(graph, source, destination, visited);
    }

    public static boolean helper(HashMap<Integer,List<Integer>> adjList, int source, int destination,int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            Integer temp = queue.poll();
            if(temp == destination) {
                return true;
            }
            for(Integer neighbour: adjList.getOrDefault(temp,new ArrayList<>())) {
                 if(visited[neighbour] != 1) {
                     visited[0] = 1;
                     queue.add(neighbour);
                 }
            }
        }
        return false;
    }
}
