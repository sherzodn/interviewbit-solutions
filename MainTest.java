package com.crossover.demo;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        A.add(1);
        A.add(4);
        A.add(5);
        A.add(8);
        A.add(10);
        B.add(6);
        B.add(9);
        B.add(15);
        C.add(2);
        C.add(3);
        C.add(6);
        C.add(6);
        //System.out.println(intersect(A, B));
        System.out.println(solve(A, B, C));
    }

    private static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B){
        ArrayList<Integer> result = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        int aSize = A.size();
        int bSize = B.size();
        while (l1!=aSize && l2 != bSize) {
            if (A.get(l1) > B.get(l2)) {
                l2++;
            } else if (A.get(l1) < B.get(l2)){
                l1++;
            } else {
                result.add(A.get(l1));
                l1++;
                l2++;
            }
        }

        return result;
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C){
        int i = A.size() - 1;
        int j = B.size() - 1;
        int k = C.size() - 1;
        int minDiff = absDiff(A.get(i), B.get(j), C.get(k));
        int currDiff;
        int maxTerm;
        while (i!=-1 && j!=-1 && k!=-1) {
            currDiff = absDiff(A.get(i), B.get(j), C.get(k));
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
            //calculating max term from list
            maxTerm = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            if (A.get(i) == maxTerm) {
                i--;
            } else if (B.get(j) == maxTerm) {
                j--;
            } else {
                k--;
            }
        }

        return minDiff;
    }

    private static int absDiff(int a, int b, int c){
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return Math.abs(max - min);
    }
}
