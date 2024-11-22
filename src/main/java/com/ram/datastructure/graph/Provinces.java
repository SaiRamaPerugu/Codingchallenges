package com.ram.datastructure.graph;

import java.util.*;

public class Provinces {

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,0,0,0},{1,1,0,0,1,0},{1,0,1,0,0,0},{0,0,0,1,0,0},{0,1,0,0,1,1},{0,0,0,0,1,1}};
//        for(int i=0; i < arr.length;i++) {
//            for(int j=0; j < arr[i].length;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        Map<Integer,List<Integer>> adjList = convertToAdjacencyList(arr);
//        System.out.println(adjList);
//
//        System.out.println(dfs(adjList));
//
//
//        System.out.println(findCircleNum(arr));
        boolean[] visited = new boolean[arr.length];
        int num = 0;
        for(int i=0; i < arr.length;i++) {
            if(!visited[i]) {
                dfsHelperArr(i, arr, visited);
                num++;
            }
        }

        System.out.println("Number of connected components: " + num);
    }

    public static void dfsHelperArr(int i, int[][] arr, boolean[] visited) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;
        for(int j=0; j < arr[i].length;j++) {
            if(arr[i][j] == 1 && !visited[j] ) {
                dfsHelperArr(j, arr, visited);
            }
        }
    }

    public static Map<Integer, List<Integer>> convertToAdjacencyList(int[][] arr) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> list;
        for(int i=0; i < arr.length; i++) {
            list = new ArrayList<>();
            for(int j=0; j < arr[i].length; j++) {
                if(i != j && arr[i][j] == 1) {
                    list.add(j);
                }
            }
            adjList.put(i, list);
        }


        return adjList;
    }

    public static int dfs(Map<Integer, List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        int provinces = 0;
        for(Integer node: adjList.keySet()) {
            if(!visited[node]) {
                System.out.println("Node: " + node);
                provinces++;
                dfsHelper(adjList, node, visited);
            }
        }

        return provinces;
    }

    public static void dfsHelper(Map<Integer, List<Integer>> adjList, Integer node, boolean[] visited) {
        List<Integer> children = adjList.get(node);
        visited[node] = true;
        for(Integer child: children) {
            System.out.println("Child of node:" + node + " is " + child);
            if(!visited[child]) {
                System.out.println("calling dfs for: " + child);
                dfsHelper(adjList, child, visited);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int[] temp = new int[isConnected.length];

        for(int i=0; i < isConnected.length;i++) {
            temp[i] = i;
        }
        System.out.println(Arrays.toString(temp));
        for(int i=0; i < isConnected.length;i++) {
            for(int j=0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    if(temp[i] < temp[j]) {
                        overWriteNum(temp, temp[j], temp[i]);
                    } else {
                        overWriteNum(temp, temp[i], temp[j]);
                    }
                }
            }
            System.out.println(Arrays.toString(temp));
        }

        System.out.println(Arrays.toString(temp));
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(temp).forEach(x -> set.add(x));

        return set.size();
    }

    public static void overWriteNum(int[] arr, int x, int y) {
        for(int i=0; i < arr.length;i++) {
            if(arr[i] == x) {
                arr[i] = y;
            }
        }
    }
}
