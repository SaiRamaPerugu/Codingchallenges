package com.ram.project;

import java.util.HashMap;

public class Fibonacci {

    static HashMap<Long,Long> results = new HashMap<>();
    public static void main(String[] args) {

        if(args.length == 0) {
            throw new RuntimeException("Enter the parameter 1 to calculate the Fibonacci value");
        }
        try {
            long num = Long.parseLong(args[0]);
            System.out.println(calculateFib(num));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static long calculateFib(long num) {
        if(results.containsKey(num))  {
            return results.get(num);
        }

        if(num < 2) {
            return num;
        }

        long x = calculateFib(num - 2);
        results.put(num-2, x);
        long y = calculateFib(num - 1 );
        results.put(num-1, y);
        return x + y;
    }
}
