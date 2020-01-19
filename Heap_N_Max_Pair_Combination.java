package com.crossover.demo;

import java.util.*;

public class Heap_N_Max_Pair_Combination {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(1,4,2,3), Arrays.asList(2,5,1,6)));
    }
    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for (int i : A) {
           for (int j : B){
               int s = i + j;
               if (pq.size() < A.size()) {
                   pq.add(s);
               } else {
                   if (s > pq.peek()) {
                       pq.poll();
                       pq.add(s);
                   } else {
                       break;
                   }
               }
           }
       }
       ArrayList<Integer> res = new ArrayList<>(pq);
       Collections.sort(res, Collections.reverseOrder());
       return res;
    }
}
