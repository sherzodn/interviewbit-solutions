package com.crossover.demo;

import java.util.*;

public class HS_2Sum {
    public static void main(String[] args) {
        System.out.println(twoSum(Arrays.asList(2, 7, 11, 15), 9));
    }

    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result  = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                result.add(map.get(B - A.get(i)) + 1);
                result.add(i+1);
            } else {
                map.put(A.get(i), i);
            }
        }

        return result;
    }
}
