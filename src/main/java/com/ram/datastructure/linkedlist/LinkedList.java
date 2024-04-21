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

    public void deleteNode(int pos) {
        int n = 1;
        Node prev = head;
        if(pos == 1) {
            head = head.next;
        } else {
            while (n < pos - 1 && prev != null) {
                Node cur = prev.next;
                prev = prev.next;
                n++;
            }
            if (prev.next != null)
                prev.next = prev.next.next;
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
