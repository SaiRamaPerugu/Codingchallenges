package com.ram.challenges.huffmantree;

public class HuffTree implements Comparable {

    private HuffBaseNode root;
    public HuffTree(char el, int weight) {
        root = new HuffLeafNode(el,weight);
    }

    public HuffTree(int weight, HuffBaseNode left, HuffBaseNode right) {
        root = new HuffInternalNode(weight, left, right);
    }

    public HuffBaseNode root() {
        return root;
    }
    public int weight() {
        return root.weight();
    }
    @Override
    public int compareTo(Object o) {
        HuffTree huffTree = (HuffTree) o;
        if(root.weight() < huffTree.weight()) {
            return  -1;
        } else if(root.weight() > huffTree.weight()) {
            return 1;
        } else {
            return 0;
        }
    }


}
