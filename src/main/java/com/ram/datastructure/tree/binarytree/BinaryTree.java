package com.ram.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public Node root() {
        return root;
    }

    public Node addNode(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            System.out.println("Val " + val + " added to root");
            return root;
        }

        if(val < root.val) {
            root.left = addNode(root.left, val);
        } else if(val > root.val) {
            root.right = addNode(root.right,val);
        }

        return root;
    }

    public void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public void printInOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = root;
        if(temp != null) {
            System.out.println(temp.val);
            System.out.println("Before while loop");
            while(!queue.isEmpty()) {
                temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
     }

}
