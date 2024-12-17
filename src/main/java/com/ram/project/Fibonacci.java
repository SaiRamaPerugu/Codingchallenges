package com.ram.project;

import java.util.HashMap;

public class Fibonacci {

    static HashMap<Integer,Integer> results = new HashMap<>();
    public static void main(String[] args) {

        if(args.length == 0) {
            throw new RuntimeException("Enter the parameter 1 to calculate the Fibonacci value");
        }
        try {
            Integer num = Integer.parseInt(args[0]);
            System.out.println(calculateFib(num));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Integer calculateFib(int num) {
        if(results.containsKey(num))  {
            return results.get(num);
        }

        if(num == 0 || num == 1) {
            return num;
        }


        int x = calculateFib(num - 2);
        results.put(num-2, x);
        int y = calculateFib(num - 1 );
        results.put(num-1, y);
        return x + y;
    }
}
