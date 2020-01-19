package com.crossover.demo;

import java.util.ArrayList;

public class Array_MaxNonNegativSubArray {
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-2);
        res.add(-5);
        res.add(-7);
        res.add(-2);
        res.add(-3);
        System.out.println(maxset(res));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int n = A.size();
        long maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int counter = 1;
        int i = 0;
        while (i != n && A.get(i) < 0) i++;
        if (i == n) return new ArrayList<>();
        start = i;
        end = i;
        long tempSum = A.get(i);
        i++;
        while (i < n) {
            if ((A.get(i) >= 0) && (A.get(i) >= A.get(i - 1))) {
                tempSum += A.get(i);
                counter++;
            } else {
                if (maxSum < tempSum) {
                    maxSum = tempSum;
                    end = i - 1;
                    start = end - counter + 1;
                    counter = 0;
                    tempSum = 0;
                }
            }

            i++;

        }

        if (maxSum < tempSum) {
            maxSum = tempSum;
            end = i - 1;
            start = end - counter + 1;
            counter = 0;
        }

        return new ArrayList<>(A.subList(start, end + 1));
    }
}

