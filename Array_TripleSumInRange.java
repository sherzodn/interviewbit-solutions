package com.crossover.demo;

import java.util.ArrayList;

/*
Solution taken here: http://interviewbit.saint1729.me/interviewbit-triplets-with-sum-between-given-range/
* */
public class Array_TripleSumInRange {
    public static int solve(ArrayList<String> A) {
        float max1A, max2A, max3A, min1A, min2A, min1B, min2B, min1C;
        max1A = max2A = max3A = Integer.MIN_VALUE;
        min1A = min2A = min1B = min2B = min1C = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            float val = Float.parseFloat(A.get(i));
            if (val <= 0.666) {
                if (val > max1A) {
                    max3A = max2A;
                    max2A = max1A;
                    max1A = val;
                } else if (val > max2A) {
                    max3A = max2A;
                    max2A = val;
                } else if (val > max3A) {
                    max3A = val;
                }
                if (val < min1A) {
                    min2A = min1A;
                    min1A = val;
                } else if (val < min2A) {
                    min2A = val;
                }
            } else if (val <= 1) {
                if (val < min1B) {
                    min2B = min1B;
                    min1B = val;
                } else if (val < min2B) {
                    min2B = val;
                }
            } else if (val < 2) {
                if (val < min1C) {
                    min1C = val;
                }
            }
        }

        float sumAAA = max1A + max2A + max3A;
        float sumAAB = max1A + max2A + min1B;
        float sumAAC = min1A + min2A + min1C;
        float sumABB = min1A + min1B + min2B;
        float sumABC = min1A + min1B + min1C;
        if ((sumAAA < 2.0 && sumAAA > 1.0) || (sumAAB < 2.0 && sumAAB > 1.0) || (sumAAC < 2.0 && sumAAC > 1.0)) {
            return 1;
        }
        if ((sumABB < 2.0 && sumABB > 1.0) || (sumABC < 2.0 && sumABC > 1.0)) {
            return 1;
        }
        return 0;
    }
}
