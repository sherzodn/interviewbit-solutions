package com.crossover.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HS_4Sum {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        HashSet<ArrayList> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                int k = j+1;
                int l = A.size() - 1;
                while (k < l) {
                    int sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);
                    if (sum > B) {
                        l--;
                    } else if (sum < B) {
                        k++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A.get(i));
                        list.add(A.get(j));
                        list.add(A.get(k));
                        list.add(A.get(l));
                        if (!set.contains(list)){
                            set.add(list);
                            result.add(list);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
