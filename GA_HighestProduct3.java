package com.crossover.demo;

public class GA_HighestProduct3 {
    public static void main(String[] args) {
        int[] arr = {1, -4, 3, -6, 7, 0};
        System.out.println("result is " + maxp3(arr));
    }

    public static int maxp3(int[] arr) {
        int n = arr.length;
        if (n < 3) return -1;
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            //update first, second and third maximums
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            } else if (arr[i] > maxB) { //update second and third maximums
                maxC = maxB;
                maxB = arr[i];
            } else if (arr[i] > maxC) { // update 3td maximum
                maxC = arr[i];
            }

            // update minimums
            if (arr[i] < minA) {
                minB = minA;
                minA = arr[i];
            } else if (arr[i] < minB) {
                minB = arr[i];
            }
        }


        System.out.println("minA=" + minA);
        System.out.println("minB=" + minB);
        System.out.println("maxA=" + maxA);
        System.out.println("maxB=" + maxB);
        System.out.println("maxC=" + maxC);

        return Math.max(minA * minB * maxA, maxA * maxB * maxC);
    }


}
