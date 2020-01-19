package com.crossover.demo;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= i;
        }
        return p;
    }

    static void find_kth_permutation(
            List<Character> v,
            int k,
            StringBuilder result) {

        if (v.isEmpty()) {
            return;
        }

        int n = v.size();
        // count is number of permutations starting with first digit
        int count = factorial(n - 1);
        int selected = (k - 1) / count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);
        find_kth_permutation(v, k, result);
    }

    static String get_permutation(int n, int k) {
        List<Character> v = new ArrayList<Character>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            v.add(c);
            c++;
        }

        StringBuilder result = new StringBuilder();
        find_kth_permutation(v, k, result);
        return result.toString();
    }

    public static void main(String[] args) {
        int perm = factorial(4);
        for (int i = 1; i <= perm; ++i) {
            System.out.println(i + "th permutation = \t" + get_permutation(4, i));
        }
    }
}


