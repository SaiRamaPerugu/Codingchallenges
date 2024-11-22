package com.ram.challenges.huffmantree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanNodeEncoder {

    public static void main(String[] args) {
        String text = "aaaabbbcc";
        HashMap<Character,Integer> frequencyTable = new HashMap<>();
        for(char c: text.toCharArray()) {
            if(frequencyTable.containsKey(c)) {
                int x = frequencyTable.get(c);
                frequencyTable.put(c,++x);
            } else {
                frequencyTable.put(c,1);
            }
        }

        System.out.println(frequencyTable);
        PriorityQueue<HuffTree> pq = new PriorityQueue<>();
        frequencyTable.forEach((key, value) -> pq.add(new HuffTree(key, value)));

        while(pq.size() > 1) {
            HuffTree temp1 = pq.poll();
            HuffTree temp2 = pq.poll();
            HuffTree temp3;
            int sumOfWeights = temp1.weight() + temp2.weight();
            if(temp1.root().isLeaf() && temp2.root().isLeaf()) {
                if(temp1.weight() < temp2.weight()) {
                    temp3 = new HuffTree(sumOfWeights, temp1.root(), temp2.root());
                } else {
                    temp3 = new HuffTree(sumOfWeights, temp2.root(), temp1.root());
                }
                pq.add(temp3);
                pq.stream().forEach(x -> {
                    HuffBaseNode baseNode = x.root();
                    System.out.println("****");
                    System.out.println("loop:" + baseNode.weight());
                    System.out.println("*******");
                });
            } else if (!temp1.root().isLeaf() && !temp2.root().isLeaf()) {
                if(temp1.weight() < temp2.weight()) {
                    temp3 = new HuffTree(sumOfWeights, temp1.root(), temp2.root());
                } else {
                    temp3 = new HuffTree(sumOfWeights, temp2.root(), temp1.root());
                }
                pq.add(temp3);
            } else if (!temp1.root().isLeaf() && temp2.root().isLeaf()) {
                if(temp1.weight() < temp2.weight()) {
                    temp3 = new HuffTree(sumOfWeights, temp1.root(), temp2.root());
                } else {
                    temp3 = new HuffTree(sumOfWeights, temp2.root(), temp1.root());
                }
                pq.add(temp3);
            } else if (temp1.root().isLeaf() && !temp2.root().isLeaf()) {
                if (temp1.weight() < temp2.weight()) {
                    temp3 = new HuffTree(sumOfWeights, temp1.root(), temp2.root());
                } else {
                    temp3 = new HuffTree(sumOfWeights, temp2.root(), temp1.root());
                }
                pq.add(temp3);
            }
        }

        System.out.println("Number of trees left:" + pq.size());
        HuffTree node = pq.poll();
        //printHuffTree(node.root());
    }

    public static void printHuffTree(HuffBaseNode root) {
          if(root.isLeaf()) {
              HuffLeafNode leafNode = (HuffLeafNode) root;
              System.out.println((char) leafNode.value() + " weight " + leafNode.weight());
              return;
          }
          HuffInternalNode internalNode = (HuffInternalNode) root;
        System.out.println(internalNode.weight() + " has child l:" + internalNode.left().weight()
        + "r:" + internalNode.right().weight());
          printHuffTree(((HuffInternalNode) root).left());
          printHuffTree(((HuffInternalNode) root).right());
    }
}
