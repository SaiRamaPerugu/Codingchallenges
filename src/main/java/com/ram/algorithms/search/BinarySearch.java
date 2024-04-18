package com.ram.algorithms.search;

import java.sql.SQLOutput;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int start = 0;
        System.out.println(search(arr, 0, arr.length, 5));
    }

    public static boolean search(int[] arr, int start, int end, int val) {
        int mid = (start + end) / 2;
        boolean found = false;
        while (start < end) {
            if (val > arr[mid]) {
                System.out.println("IN BLOCK 1");
                return search(arr, mid + 1, end, val);
            } else if (val < arr[mid]) {
                System.out.println("IN BLOCK 2");
                return search(arr, start, mid, val);
            } else {
                System.out.println("IN found block");
                System.out.println("found " + val);
                found = true;
                System.out.println("start:" + start + ",end:" + end);
                return true;
            }
        }
        return found;
    }
}
