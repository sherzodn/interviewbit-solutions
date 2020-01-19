package com.crossover.demo;

public class Array_ArrangeNegativAndPositive {
    public static void main(String[] args) {
        int[] arr = {4, -3, 3, -6, 1, -7, 2};
        printArray(arr);
        arrangeWithOrder(arr);
        printArray(arr);
    }

    private static void arrange(int[] arr) {
        int i, j;
        j = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (j != i) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    private static void arrangeWithOrder(int[] arr) {
        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            if (temp > 0) continue;
            j = i - 1;
            while (arr[j] > 0 && j >= 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
