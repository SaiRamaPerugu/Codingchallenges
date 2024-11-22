package com.ram.challenges.huffmantree;

public class HuffInternalNode implements  HuffBaseNode {

    private int weight;
    private HuffBaseNode left;
    private HuffBaseNode right;
    public HuffInternalNode(int weight, HuffBaseNode left, HuffBaseNode right) {
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public HuffBaseNode left() {
        return left;
    }

    public HuffBaseNode right() {
        return right;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public int weight() {
        return 0;
    }


}
