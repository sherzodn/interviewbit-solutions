package com.crossover.demo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class Backtracking_CombinationSum {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A.size() == 0) return ans;
        ArrayList<Integer> temp = new ArrayList<>();
        combinationSumHelper(A, B, ans, temp, 0);
        return ans;
    }

    private static void combinationSumHelper(ArrayList<Integer> a, int b, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int start) {
        if (b < 0) return;

        if (b==0) {
            if (!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
        } else {
            for (int i = start; i < a.size(); i++) {
                //choose
                temp.add(a.get(i));
                //explore
                combinationSumHelper(a, b-a.get(i), ans, temp, i);
                //un-choose
                temp.remove(temp.size() - 1);
            }
        }
    }
}
