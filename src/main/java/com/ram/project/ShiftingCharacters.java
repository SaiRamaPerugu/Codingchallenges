package com.ram.project;

import java.util.Arrays;

public class ShiftingCharacters {

    public static void main(String[] args) {
        System.out.println(shiftingLetters("mkgfzkkuxownxvfvxasy",
                new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
    }

    public  static String shiftingLetters(String s, int[] shifts) {
        double[] modifiedShifts = new double[shifts.length];
        double sum = 0;
        for(int i= shifts.length-1; i >= 0; i--) {
            sum += shifts[i];
            modifiedShifts[i] = sum;
            modifiedShifts[i] = sum%26;
        }

        //System.out.println(Arrays.toString(modifiedShifts));
       // System.out.println(Arrays.toString(asciiValues));
        int[] asciiValues = new int[s.length()];
        for(int i=0;i < modifiedShifts.length;i++) {
            asciiValues[i] = (int) modifiedShifts[i]  + s.charAt(i);
            while(asciiValues[i] > 122) {
                asciiValues[i] = (asciiValues[i] % 122) + 96;
            }
        }

        //System.out.println(Arrays.toString(modifiedShifts));
        //System.out.println(Arrays.toString(asciiValues));
        StringBuilder result = new StringBuilder();
        for(int i=0;i < s.length();i++) {
            result.append((char) asciiValues[i]);
        }
        return result.toString();
    }
}
