package com.ram.datastructure.graph;

import java.util.*;

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


        boolean[] visited = new boolean[101];
        //printGraphDFS(node1, visited);
        printGraphBFS(node1);
        System.out.println("*************");
        Node copyNode = cloneGraph(node1);
        printGraphBFS(copyNode);

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


    public static void printGraphDFS(Node node, boolean[] visited) {
        System.out.println("Parent node: " + node.val);
        visited[node.val] = true;
        for(Node child: node.neighbors) {
            if(!visited[child.val]) {
                System.out.println(" if Child of " + node.val + " is " + child.val);
                printGraphDFS(child, visited);
            }
        }
    }

    public static void printGraphBFS(Node node) {

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(!visited[temp.val]) {
                System.out.println(temp.val);
                List<Node> neighbors = temp.neighbors;
                queue.addAll(neighbors);
                visited[temp.val] = true;
            }
        }
    }

    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            Node clone = map.get(curr);
            for(Node neighbor: curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                clone.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
