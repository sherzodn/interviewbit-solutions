package com.crossover.demo;

import java.util.*;

public class Heap_Chocolate {
    public static void main(String[] args) {
        System.out.println(nchoc(3, Arrays.asList(50, 5)));
    }

    public static int nchoc(int A, List<Integer> B) {
        final int MOD = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.addAll(B);
        long total = 0L;
        while (A-- > 0) {
            int choc = pq.poll();
            total += choc;
            total %= MOD;
            pq.add(choc / 2);
        }

        return (int) total;
    }
}
