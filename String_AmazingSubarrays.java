package com.crossover.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_AmazingSubarrays {
    public static void main(String[] args) {

    }

    public static int solve(String A) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int strLength = A.length();
        int result = 0;
        for (int i = 0; i < strLength; i++) {
            if (isVowel(vowels, A.charAt(i))) {
                result += (strLength - i);
                result %= 10003;
            }
        }
        return result;
    }

    private static boolean isVowel(char[] vowels, char ch) {
        for (char vowel : vowels) {
            if (ch == vowel) return true;
        }
        return false;
    }
}
