package com.crossover.demo;

public class DP_Ways_To_Decode {
    public static void main(String[] args) {
        System.out.println(numDecodings("121"));
    }

    public static int numDecodings(String A) {
        int numberOfOneChar = 1;
        int numberOfTwoChars = 1;
        if (A.length() == 0 || A.charAt(0) < '1') return 0;
        for (int i = 1; i < A.length(); i++) {
            int temp = 0;
            boolean b1 = isValidChar(A.charAt(i));
            boolean b2 = isValidChars(A.charAt(i - 1), A.charAt(i));
            if (!b1 && !b2) return 0;
            if (b1) temp = numberOfOneChar;
            if (b2) temp += numberOfTwoChars;
            numberOfTwoChars = numberOfOneChar;
            numberOfOneChar = temp;
        }
        return numberOfOneChar;
    }

    private static boolean isValidChar(char c) {
        return c != '0';
    }

    private static boolean isValidChars(char c1, char c2) {
        return ((c1 == '1' && c2 >= '0') || (c1 == '2' && c2 < '7'));
    }

}
