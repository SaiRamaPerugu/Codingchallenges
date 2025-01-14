package com.ram.datastructure.graph;

import java.util.*;

public class PathBetweenNodesUnionFind {

    public static void main(String[] args) {
        //int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int[][] edges =  {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath(9,edges,0, 1));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        //initialize array
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0; i < parent.length;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        System.out.println(Arrays.toString(parent));
        for(int[] edge: edges) {
            union(parent, rank, edge[0], edge[1]);
            System.out.println("Parent:" + Arrays.toString(parent));
            System.out.println("Rank: " + Arrays.toString(rank));
        }

        return find(parent,source) == find(parent,destination);
    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent,parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent,x);
        int rootY = find(parent,y);
        System.out.println("RootX, rootY: " + rootX + "," + rootY);
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
