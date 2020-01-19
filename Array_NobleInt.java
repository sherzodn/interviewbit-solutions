package com.crossover.demo;

import java.util.ArrayList;
import java.util.Collections;

public class Array_NobleInt {
    public static void main(String[] args) {

    }

    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n; i++) {
            // Handle duplicates (only check for rightmost duplicate), skip others
            if (i < n-1 && A.get(i) == A.get(i+1)) {
                continue;
            }
            // Check if the remaining values to the right are equal to the current value
            if (A.get(i) == n - i - 1) return 1;
        }
        return -1;
    }
}
