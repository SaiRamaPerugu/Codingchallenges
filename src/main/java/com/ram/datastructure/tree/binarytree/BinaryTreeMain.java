package com.ram.datastructure.tree.binarytree;


import java.util.Arrays;
import java.util.List;

public class BinaryTreeMain {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,10,21,23);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(4);
        binaryTree.insert(14);
        binaryTree.printTree(binaryTree.root);
        System.out.println();
        System.out.println("********");
        binaryTree.printInOrder(binaryTree.root);
    }
}