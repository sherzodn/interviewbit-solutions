package com.crossover.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HS_DiffkII {
    public static void main(String[] args) {
        System.out.println(diffPossible(Arrays.asList(1,5,3), 2));
    }

    public static int diffPossible(final List<Integer> A, int B) {
        if (A.size() <=1 ) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : A){
            if (set.contains(num+B)  || set.contains(num-B)){
                return 1;
            }
            set.add(num);
        }

        return 0;
    }
}
