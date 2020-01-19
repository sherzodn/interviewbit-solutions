package com.crossover.demo;

import java.util.ArrayList;
import java.util.Collections;

public class Array_SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(A, 0));
            result.add(temp);
        }

        // Initialization counters
        int row = 0;
        int column = 0;
        int start = 0;
        int end = A;
        String dir = "R";
        int n = 1;
        int limit = A * A;
        //looping logic
        while (n <= limit) {
            if ("R".equals(dir)) {
                while (column < end && n <= limit) {
                    result.get(row).set(column, n);
                    n++;
                    column++;
                }
                row++;
                column--;
                dir = "D";
            } else if ("D".equals(dir)) {
                while (row < end && n <= limit) {
                    result.get(row).set(column, n);
                    row++;
                    n++;
                }
                row--;
                column--;
                dir = "L";
                end--;
            } else if ("L".equals(dir)) {
                while (column >= start && n <= limit) {
                    result.get(row).set(column, n);
                    n++;
                    column--;
                }
                column++;
                row--;
                dir = "U";
                start++;
            } else if ("U".equals(dir)) {
                while (row >= start && n <= limit) {
                    result.get(row).set(column, n);
                    n++;
                    row--;
                }
                row++;
                column++;
                dir = "R";
            }

        }

        return result;
    }
}
