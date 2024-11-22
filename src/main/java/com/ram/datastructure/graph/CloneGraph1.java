package com.ram.datastructure.graph;

import java.util.ArrayList;

public class CloneGraph1 {

    public static void main(String[] args) {
            /*
                1-----2
                |     |
                3-----4
             */

         Node node2 = new Node(2);
         Node node3 = new Node(3);
         ArrayList<Node> list1 = new ArrayList<>();
        list1.add(node2);
         list1.add(node3);
         Node node1 = new Node(1,list1);
         ArrayList<Node> list2 = new ArrayList<>();
        Node node4 = new Node(4);
        list2.add(node1);
         list2.add(node4);
         node2.neighbors = list2;
        ArrayList<Node> list3 = new ArrayList<>();
        list3.add(node1);
        list3.add(node4);
        node3.neighbors = list3;
        ArrayList<Node> list4 = new ArrayList<>();
        list4.add(node2);
        list4.add(node3);
        node4.neighbors = list4;

        printGraph(node1);
        System.out.println("**************");
        Node dup = cloneGraph(node1);
        printGraph(dup);
    }

    public static void printGraph(Node node) {
        boolean[] visited = new boolean[5];
        dfs(node, visited);
    }

    public static Node cloneGraph(Node node) {
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        dfsCopy(node, copy, visited);
        return copy;
    }

    public static void dfsCopy(Node node, Node copy, Node[] visited) {
        visited[node.val] = node;
        for(Node child: node.neighbors) {
            if(visited[child.val] == null) {
                Node temp = new Node(child.val);
                copy.neighbors.add(temp);
                dfsCopy(child, temp, visited);
            } else {
                copy.neighbors.add(visited[child.val]);
            }
        }
    }

    public static void dfs(Node node,boolean[] visited) {
        System.out.println("Parent node:" + node.val);
        visited[node.val] = true;
        for(Node child: node.neighbors) {
            if(!visited[child.val]) {
                System.out.println("Child " + child.val + " of Parent " + node.val);
                dfs(child, visited);
            } else {
                //System.out.println("else Child " + child.val + " of Parent " + node.val);
            }
        }
    }

}

