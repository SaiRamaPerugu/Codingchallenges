package com.ram.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    public BinaryTree() {
        root = null;
    }

    public void add(int val) {
        root = insert(root,val);
    }

    public Node insert(Node node, int val) {
        if(node == null) {
            node = new Node(val);
            return node;
        }
        if(val < node.val) {
            node.left = insert(node.left,val);
        } else if(val > node.val) {
            node.right = insert(node.right,val);
        }
        return node;
    }

    public void printTree() {
        printInLineTraversal(root);
    }

    public void print(Node node) {
        if(node == null) {
            return;
        }
        print(node.left);
        System.out.println(node.val);
        print(node.right);
    }

    public void printInLineTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.println(node.val);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left != null) {
                System.out.print(temp.left.val + " ");
                queue.add(temp.left);
            }

            if(temp.right != null) {
                System.out.println(temp.right.val);
                queue.add(temp.right);
            }
        }
    }
}
