package com.crossover.demo;

import java.util.HashSet;

public class HS_Colorful {
    public static void main(String[] args) {
        System.out.println(colorful(3245));
    }

    public static int colorful(int A) {
        HashSet<Integer> set = new HashSet<>();
        String inputStr = Integer.toString(A);
        for (int i = 0; i < inputStr.length(); i++) {
            int mul = 1;
            for (int j = i; j < inputStr.length(); j++) {
                mul *= inputStr.charAt(j) - '0';
                if (set.contains(mul)) {
                    return 0;
                }
                set.add(mul);
            }
        }
        System.out.println(set);
        return 1;
    }

}
