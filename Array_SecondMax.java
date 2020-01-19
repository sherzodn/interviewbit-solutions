package com.crossover.demo;

public class Array_SecondMax {
    public static void main(String[] args) {
        System.out.println(findSecondMax(new int[]{13, 1, 4, 2, -1, 0}));
    }

    private static int findSecondMax(int[] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]){
                max2 = max1;
                max1 = arr[i];
            } else if (max2 < arr[i]) {
                max2 = arr[i];
            }
        }

        return max2;
    }
}
