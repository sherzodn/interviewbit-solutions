package com.crossover.demo;

public class Game_Stones {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " can win? " + canWinNim(i));
        }
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
