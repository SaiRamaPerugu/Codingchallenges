package com.ram.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        /*
            1---2
            |   |
            |   |
            4---3
         */

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        ArrayList<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        Node node1 = new Node(1, list1);
        ArrayList<Node> list2 = new ArrayList();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors = list2;
        ArrayList<Node> list3 = new ArrayList();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors = list3;
        ArrayList<Node> list4 = new ArrayList();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors = list4;

        //Node copyNode = cloneGraph(node1);
        boolean[] visited = new boolean[101];
        printGraph(node1, visited);
        System.out.println("***********");
        boolean[] visited1 = new boolean[101];
        //printGraph(copyNode,visited1);

    }

    public static void dfs(Node node, Node copy, Node[] visited) {
        visited[node.val] = copy;
        for(Node child: node.neighbors) {
            if(visited[child.val] == null) {
                Node newNode = new Node(child.val);
                copy.neighbors.add(newNode);
                dfs(child, newNode, visited);
            } else {
                copy.neighbors.add(visited[child.val]);
            }
        }
    }

    public static void printGraph(Node node, boolean[] visited) {
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
        dfs(node, copy, visited);
        //System.out.println(node.neighbors);
        return copy;
    }
}
