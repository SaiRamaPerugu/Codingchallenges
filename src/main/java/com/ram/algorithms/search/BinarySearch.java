package com.ram.algorithms.search;
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int start = 0;
        System.out.println(search(arr, 0, arr.length, 6));
    }

    public static int search(int[] arr, int start, int end, int val) {

        while (start < end) {
            int mid = (start + end) / 2;
            if (val > arr[mid]) {
                System.out.println("IN BLOCK 1");
                start = mid + 1;
            } else if (val < arr[mid]) {
                System.out.println("IN BLOCK 2");
                end = mid - 1;
            } else {
                System.out.println("IN found block");
                System.out.println("found " + val);
                System.out.println("start:" + start + ",end:" + end);
                return mid;
            }
        }
        return -1;
    }
}
