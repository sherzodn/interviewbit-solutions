package com.crossover.demo;

import java.util.List;

public class HS_Sudoku {
    public static void main(String[] args) {

    }

    public static int isValidSudoku(final List<String> A) {
        // checking horizontal rows
        for (String s : A) {
            if (!isValid(s)) {
                return 0;
            }
        }
        // checking vertical columns
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (String s : A) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    count[Character.getNumericValue(c) - 1]++;
                    if (count[Character.getNumericValue(c) - 1] > 1) {
                        return 0;
                    }
                }
            }
        }

        // check that 3x3 boxes are valid
        for (int i = 0; i < 9; i += 3) {
            StringBuilder[] sbs = new StringBuilder[3];
            for (int k = 0; k < 3; k++) {
                sbs[k] = new StringBuilder("");
            }

            for (int j = 0; j < 3; j++) {
                String str = A.get(i + j);
                sbs[0].append(str.substring(0, 3));
                sbs[1].append(str.substring(3, 6));
                sbs[2].append(str.substring(6, 9));
            }

            for (int k = 0; k < 3; k++) {
                if (!isValid(sbs[k].toString())) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[9];
        for (char c : chars) {
            if (Character.isDigit(c)) {
                count[Character.getNumericValue(c) - 1]++;
                if (count[Character.getNumericValue(c) - 1] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
