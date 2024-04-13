package com.ram.datastructure.linkedlist;

public class LinkedList {

    private Node head;

    public void addNode(int val){
        if(head == null) {
            head = new Node(val);
        } else {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
    }

    public void printHead(){
        System.out.println();
        System.out.print(head.val);
    }
    public void print() {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}
