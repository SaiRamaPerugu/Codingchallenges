package com.ram.datastructure.graph;

import java.util.*;

public class PathBetweenNodesUnionFind {

    public static void main(String[] args) {
        //int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int[][] edges =  {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath(10,edges,0, 9));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        //initialize array
        int[] edge = new int[n];
        for(int i=0; i < edge.length;i++) {
            edge[i] = i;
        }
        System.out.println(Arrays.toString(edge));
        for(int[] edge1: edges) {
            if(!find(edge, edge1[0] ,edge1[1])){
                union(edge, edge1[0], edge1[1]);
            }
            System.out.println(Arrays.toString(edge));
        }

        System.out.println(Arrays.toString(edge));
        return find(edge,source,destination);
    }

    public static void union(int[] edges, int source, int destination) {
        int x = edges[source];
        int y = edges[destination];
        System.out.println("Source:" + source + " destination: " + destination);
        if(x < y) {
            edges[destination] = x;
            for(int i=0; i < edges.length;i++) {
                if(edges[i] == y) {
                    edges[i] = x;
                }
            }
        } else {
            edges[source] = y;
            for(int i=0; i < edges.length;i++) {
                if(edges[i] == x) {
                    edges[i] = y;
                }
            }
        }
    }

    public static boolean find(int[] edges, int source, int destination) {
        return edges[source] == edges[destination];
    }
}
