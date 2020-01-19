package com.crossover.demo;

public class Inversion_Count {
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static int mergeSortAndCount(int arr[], int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);

            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    private static int mergeAndCount(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int swaps = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps = swaps + ((m + 1) - (l + i));
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;

    }
}
