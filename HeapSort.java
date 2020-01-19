package com.crossover.demo;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 2, 9, 13, 57, 25, 17, 1, 90, 3};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void sort(int[] A) {
        int n = A.length;


        for (int i = n / 2; i >= 0; i--) {
            heapify(A, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temporary = A[0];
            A[0] = A[i];
            A[i] = temporary;

            // call max heapify on the reduced heap
            heapify(A, i, 0);
        }


    }

    private static void heapify(int A[], int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && A[leftChild] > A[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && A[rightChild] > A[largest]) {
            largest = rightChild;
        }

        // if largest is not root
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            // recursively heapify the affected sub-tree
            heapify(A, n, largest);
        }
    }

}
