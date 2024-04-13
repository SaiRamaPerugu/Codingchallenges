package com.ram.datastructure.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=0; i < 100000;i++) {
            linkedList.addNode(i);
        }
        linkedList.print();
        linkedList.printHead();
    }
}
