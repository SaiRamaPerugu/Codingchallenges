package com.ram.challenges.huffmantree;

public class HuffLeafNode implements  HuffBaseNode {

    private char element;
    private int weight;

    public HuffLeafNode(char el, int weight) {
        this.element = el;
        this.weight = weight;
    }

    public int value() {
        return element;
    }
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public int weight() {
        return weight;
    }

}
