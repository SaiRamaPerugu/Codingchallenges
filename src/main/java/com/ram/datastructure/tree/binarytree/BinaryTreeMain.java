package com.ram.datastructure.tree.binarytree;


import java.util.Arrays;
import java.util.List;

public class BinaryTreeMain {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,10,21,23);
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Root to begin:" + binaryTree.root());
        binaryTree.root =  binaryTree.addNode(binaryTree.root(),1);
        System.out.println("Root to begin:" + binaryTree.root().val);
        binaryTree.addNode(binaryTree.root, 2);
        binaryTree.addNode(binaryTree.root, 3);
        binaryTree.printTree(binaryTree.root());
        binaryTree.printInOrder(binaryTree.root());
    }
}
