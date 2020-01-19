package com.crossover.demo;

public class Sorting_CountSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        countSort(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }

    public static void countSort(int[] arr) {
        int n = arr.length;
        int k = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) k = arr[i];
        }

        int[] count = new int[k + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        int[] b = new int[n];
        for (int i = n - 1; i >= 0 ; i--) {
            b[--count[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = b[i];
        }

    }
}
