package com.ram.datastructure.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=1; i < 10;i++) {
            linkedList.addNode(i);
        }
        linkedList.print();
        System.out.println();
        linkedList.deleteNode(8);
        linkedList.print();
    }
}
