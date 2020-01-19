package com.crossover.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HS_LongestCons {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2)));
    }

    public static int longestConsecutive(final List<Integer> A) {
        int ans = 0;

        HashSet<Integer> set = new HashSet<>(A);

        for (Integer num : A) {
            if (!set.contains(num - 1)) {
                int temp = 0;
                int j = num;
                while (set.contains(j)) {
                    j++;
                    temp++;
                }
                ans = Math.max(ans, temp);
            }
        }

        return ans;

    }
}
