package com.ram.datastructure.graph;

import java.lang.reflect.Array;
import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        /*
            1---2
            |   |
            |   |
            4---3
         */
        List<List<Integer>> adjList  = new ArrayList<>();
        adjList.add(List.of(2,4));
        adjList.add(List.of(1,3));
        adjList.add(List.of(2,4));
        adjList.add(List.of(1,3));
        Node[] arr = new Node[5];
        Arrays.fill(arr, null);
        int startNode = 1;
        for(List<Integer> list: adjList) {
            Node node;
            List<Node> neighbors;
            if(arr[startNode] == null) {
                node = new Node(startNode);
                node.neighbors = new ArrayList<>();
            } else {
                node = arr[startNode];
            }

            for(Integer num: list) {
                Node node1;
                if(arr[num] == null) {
                   node1 = new Node(num);
                } else {
                    node1 = arr[num];
                }
                //System.out.println(node1);
                node.neighbors.add(node1);
                //System.out.println(neighbors.size());
               // System.out.println(node.neighbors.size());
            }
            System.out.println(node);
            startNode++;
        }
        boolean[] visited = new boolean[5];
        for(Node node: arr) {
            System.out.println(node);
        }
        printGraph(arr[1], visited);
    }

    public static void printGraph(Node node, boolean[] visited) {
        if(node == null) {
            return;
        }
        System.out.println("Parent node: " + node.val);
        visited[node.val] = true;
        for(Node child: node.neighbors) {
            if(!visited[child.val]) {
                System.out.println(" if Child of " + node.val + " is " + child.val);
                printGraph(child, visited);
            } else {
                System.out.println(" else Child of " + node.val + " is " + child.val);
            }
        }
    }

    public static Node cloneGraph(Node node) {
        System.out.println(node);
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        //System.out.println(node.neighbors);
        return copy;
    }
}
