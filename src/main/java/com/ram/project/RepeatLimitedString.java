package com.ram.project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RepeatLimitedString {

    public static void main(String[] args) {
        String result = repeatLimitedString("zzzzzzcab",2);
        System.out.println(result);
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] frequencyArray = new int[26];
        for(int c: s.toCharArray()) {
            frequencyArray[c-97]++;
        }
        //System.out.println(Arrays.toString(frequencyArray));

        PriorityQueue<int[]> pq = new PriorityQueue<>((c1,c2) -> c2[0] - c1[0]);
        for(int i=0; i < frequencyArray.length;i++) {
            if(frequencyArray[i] != 0) {
                pq.add(new int[]{i+'a', frequencyArray[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();
            int count = curr[1];
            int ch = curr[0];
            int used = Math.min(repeatLimit, count);
            System.out.println(count + "," + repeatLimit + "," + used);
            count -= used;
            while(used > 0) {
                result.append((char) ch);
                used--;
            }

            //System.out.println("1:" + result);
            if(count > 0 && !pq.isEmpty()) {
                System.out.println("in loop" + count);
                int[] next = pq.poll();
                int nextChar = next[0];
                int nextCount = next[1];
                if(nextCount > 0) {
                    result.append((char) nextChar);
                    nextCount--;
                }

                if(nextCount > 0)
                     pq.offer(new int[]{nextChar, nextCount});
                pq.offer(new int[]{ch, count});
            }
            //System.out.println(result);
            //System.out.println("PQ size:" + pq.size());
        }
        return result.toString();
    }

    /*
            Pq = [z,4],[c,2],[a,3]
            pq.poll
                repeatlimit = 3
                [z,4]  char = z, count = 4
                used = Math.min(4,3)
                used = 3
                Append z 3 times

                count = count - used, 4 - 3 1

                count > 0
             pq.poll -> get next
                 next ch = c
                 next count = 2
                 put back next [c,1]



    */

}