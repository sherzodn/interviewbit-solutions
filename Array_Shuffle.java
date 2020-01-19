package com.crossover.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Array_Shuffle {
    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 3, 5};
        printArray(arr);
        shuffle(arr);
        printArray(arr);

    }

    private static void shuffle(int[] arr){
        Random random = new Random();
        for (int i = arr.length; i > 0 ; i--) {
            swap(arr, i-1, random.nextInt(i));
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
