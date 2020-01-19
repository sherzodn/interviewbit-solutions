package com.crossover.demo;

import java.util.Collections;
import java.util.List;

public class AlgoTest {
    public static void main(String[] args) {
        /*List A = Arrays.asList(6, 1, 3, 5, 2, 4);
        System.out.println(kthsmallest(A, 3));*/
      //  List A = Arrays.asList(10, 5, 1, 0, 2);
        //System.out.println(numRange(A, 6, 8));
       /* for (int i = 0; i < 10; i++) {
            System.out.println("i = "+i+ " parent ind="+ (i + i & (-i)));
        }*/

      // LRUCache lruCache = new LRUCache(2);
        Cashe_Solution_LRU lruCache = new Cashe_Solution_LRU(2);
       lruCache.set(1, 10);
       lruCache.set(5, 12);
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6, 14);
        System.out.println(lruCache.get(5));

    }

    public static int kthsmallest(final List<Integer> A, int B) {
        Collections.sort(A);
        return A.get(B - 1);
    }

    public static int numRange(List<Integer> A, int B, int C) {
        int count1= count(A, A.size(), C + 1);
        int count2= count(A, A.size(), B);
        return  count1 - count2;
    }

    public static int count(List<Integer> A, int aSize, int k) {
        int start = 0, end = 0;
        int count = 0;
        int sum = A.get(0);
        while (start < aSize && end < aSize) {
            if (sum < k) {
                end++;
                if (start <= end) {
                    count += end - start;
                }
                if (end < aSize) {
                    sum += A.get(end);
                }
            } else {
                sum -= A.get(start);
                start++;
            }
        }
        return count;
    }

// this is my solution
/*
    public static int numRange(List<Integer> A, int B, int C) {
        int index = 0;
        int aSize = A.size();
        int sum;
        int count = 0;
        while (index != aSize) {
            int j = index;
            sum = 0;
            while (j != aSize) {
                sum += A.get(j);
                if (sum >= B && sum <= C) {
                    count++;
                    j++;
                } else if (sum < B) {
                    j++;
                } else {
                    index++;
                    break;
                }

                if (j==aSize) {
                    index++;
                }
            }
        }

        return count;
    }
*/

}
