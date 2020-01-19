package com.crossover.demo;

public class Array_RightRotate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr);
        rightRotate(arr, 3);
        printArray(arr);
        //rightRotate(arr);
        //printArray(arr);
    }

    private static int[] rightRotate(int[] arr) {
        int temp = arr[arr.length - 1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void reverseArray(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rightRotate(int[] arr, int d){
        reverseArray(arr, 0, arr.length-1);
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, arr.length-1);
    }
}
