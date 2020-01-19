package com.crossover.demo;

public class Hamming_Distance_Two_Integer {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        System.out.println(hammingDistance1(1075050, 1199991));
        System.out.println(System.nanoTime() - t1);

        t1 = System.nanoTime();
        System.out.println(hammingDistance2(1075050, 1199991));
        System.out.println(System.nanoTime() - t1);
    }

    public static int hammingDistance1(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            result += (x % 2 != y % 2) ? 1 : 0;
            x /= 2;
            y /= 2;
        }
        return result;
    }

    public static int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int setBits = 0;

        while (z > 0) {
            setBits += z & 1;
            z >>= 1;
        }

        return setBits;
    }


}
