package com.crossover.demo;

public class BIT_BinaryIndexedTree {
    final static int MAX = 1000;
    static int BITree[] = new int[MAX];

    /* n --> No. of elements present in input array.
    BITree[0..n] --> Array that represents Binary
                    Indexed Tree.
    arr[0..n-1] --> Input array for which prefix sum
                    is evaluated. */

    // Returns sum of arr[0..index]. This function
    // assumes that the array is preprocessed and
    // partial sums of array elements are stored
    // in BITree[].
    public static int getSum(int index) {
        int sum = 0;
        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index > 0) {
            sum += BITree[index];
            // Move index to parent node in
            // getSum View
            index -= index & (-index);
        }

        return sum;
    }

    public static void updateBIT(int n, int index, int val){
        index = index + 1;
        while (index <= n) {
            BITree[index]+=val;
            index += index&(-index);
        }
    }

    public static void constructBITree(int arr[], int n){
        for (int i = 1; i <= n; i++) {
            BITree[i]=0;
        }

        for (int i = 0; i < n; i++) {
            updateBIT(n, i, arr[i]);
        }
    }

    public static void main(String[] args) {
        int freq[] = {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};
        int n = freq.length;
        constructBITree(freq, n);
        System.out.println("Sum of elements in arr[0..5] is "+ getSum(5));
        // Let use test the update operation
        freq[3] += 6;

        // Update BIT for above change in arr[]
        updateBIT(n, 3, 6);
        System.out.println("Sum of elements in arr[0..5] after update is "+ getSum(5));

    }
}
