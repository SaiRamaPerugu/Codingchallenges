package com.ram.project;

import java.util.HashMap;

public class Fibonacci {

    static HashMap<Long,Long> results = new HashMap<>();
    public static void main(String[] args) {

        if(args.length == 0) {
            throw new RuntimeException("Enter the parameter 1 to calculate the Fibonacci value");
        }
        try {
            long num = Integer.parseInt(args[0]);
            System.out.println(calculateFib(num));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static long calculateFib(long num) {
        if(results.containsKey(num))  {
            System.out.println("Found value for " + num + " in cache");
            return results.get(num);
        }

        long result = 0;
        if(num < 2) {
            result = num;
        } else {
            result = calculateFib(num - 2) + calculateFib(num - 1 );
        }
        return result;
    }
}
