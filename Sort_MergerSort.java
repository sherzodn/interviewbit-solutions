package com.crossover.demo;

public class Sort_MergerSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        printArray(arr);
        sort(arr, 0, arr.length - 1);
        printArray(arr);


    }

    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // find the middle point
            int m = (l + r) / 2;
            // sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            //Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Mergers two subarrays of arr[]
    //First subarray is arr[l, m]
    //second subarray is arr[m+1, r]
    private static void merge(int arr[], int l, int m, int r) {
        //Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        int left[] = new int[n1];
        int right[] = new int[n2];

        //copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        // merge the temp arrays

        // initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // initial subarray of merged subarray
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of left[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // copy remaining elements of right[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    private static void printArray(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
