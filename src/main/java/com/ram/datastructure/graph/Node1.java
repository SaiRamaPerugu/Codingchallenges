package com.ram.datastructure.graph;

import java.util.ArrayList;

public class Node1 {

    public int val;
    public ArrayList<Node1> neighbors;

    public Node1(int val) {
        this.val = val;
    }

    public Node1(int val, ArrayList<Node1> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
