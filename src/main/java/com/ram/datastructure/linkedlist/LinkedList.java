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

   /* addNode(7, 4) - Add 7 at position 4
       0-> 1 -> 2 -> 3 -> 4
       i=1
           i=2
                i=3     prev
                    i=4 cur = node
   * */
    public void addNode(int val, int pos) {
        Node cur = head;
        Node prev = head;
        int i = 1;
        while(i < pos) {
            prev = prev.next;
            i++;
        }
        System.out.println("Previous node value is: " + prev.val);
        Node temp = new Node(val);
        prev.next = temp;
    }
}
