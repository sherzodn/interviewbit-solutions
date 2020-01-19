package com.crossover.demo;

import java.util.ArrayList;

public class Array_Flip {
    public static void main(String[] args) {
        System.out.println(flip("1001"));
    }

    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 1;
        res.add(0);
        res.add(0);
        int count = -1;
        boolean all1 = true;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length(); i++) {
            if (count<0) {
                count=0;
                start = i + 1;
            }
            char c = A.charAt(i);
            if (c=='0'){
                count++;
                all1=false;
            } else {
                count--;
            }

            if (count > max) {
                max = count;
                res.set(0, start);
                res.set(1, i+1);
            }
        }

        if (all1) return new ArrayList<>();
        return res;
    }
}
