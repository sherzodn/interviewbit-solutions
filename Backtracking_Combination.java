package com.crossover.demo;

import java.util.ArrayList;

public class Backtracking_Combination {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A < B) return ans;
        ArrayList<Integer> temp = new ArrayList<>();
        combineHelper(A, B, ans, temp, 1);
        return ans;
    }

    private static void combineHelper(int a, int b, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int start) {
        if (temp.size() > b) return;

        if (temp.size()==b && !ans.contains(temp)){
            ans.add(new ArrayList<>(temp));
        }

        for (int i = start; i < a; i++) {
            if (temp.contains(i)){
                continue;
            }
            //choose
            temp.add(i);
            //explore
            combineHelper(a, b, ans, temp, i+1);
            //un-choose
            temp.remove(temp.size() - 1);
        }

    }
}
