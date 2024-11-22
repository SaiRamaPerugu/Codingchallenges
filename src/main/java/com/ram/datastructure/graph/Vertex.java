package com.ram.datastructure.graph;

public class Vertex {
    String label;
    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
