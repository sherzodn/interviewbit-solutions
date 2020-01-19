package com.crossover.demo;

import java.util.ArrayList;
import java.util.List;

public class DP_LIDS {
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }

        if (A.size() == 1) {
            return 1;
        }

        int[] lis = lisArray(A);
        int[] lds = ldsArray(A);

        int max = 0;

        int sum;

        for (int i = 0; i < A.size(); i++) {
            sum = lis[i] + lds[A.size() - i - 1] - 1;
            max = max > sum ? max : sum;
        }
        return max;
    }

    public int binarySearch(int[] searchArray, int low, int high, int x) {
        while (low < high) {
            int mid = (low+high)/2;
            if (x < searchArray[mid]) {
                high = mid;
            } else if (x > searchArray[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public int[] lisArray(List<Integer> input) {
        int[] searchArray = new int[input.size()];
        searchArray[0] = input.get(0);
        int length = 0;

        int[] lis = new int[input.size()];
        lis[0] = 1;

        for (int i = 1; i < input.size(); i++) {
            int x = input.get(i);
            if (x <= searchArray[length]) {
                int index = binarySearch(searchArray, 0, length, x);
                searchArray[index] = x;
                lis[i] = index + 1;
            } else {
                searchArray[++length] = x;
                lis[i] = length + 1;
            }
        }
        return lis;
    }

    public int[] ldsArray(List<Integer> input) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            reverse.add(input.get(input.size() - i - 1));
        }
        return lisArray(reverse);
    }
}
