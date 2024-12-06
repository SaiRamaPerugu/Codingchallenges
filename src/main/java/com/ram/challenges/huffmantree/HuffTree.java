package com.ram.challenges.huffmantree;

import java.util.LinkedList;
import java.util.Queue;

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

    public void printTree() {
        Queue<HuffBaseNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            HuffBaseNode temp = queue.poll();
            if(!temp.isLeaf()) {
                System.out.println(temp.weight());
                queue.add(((HuffInternalNode) temp).left());
                queue.add(((HuffInternalNode) temp).right());
            } else {
                System.out.println(temp.weight());
            }
        }
    }
}
