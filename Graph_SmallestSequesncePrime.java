package com.crossover.demo;

import java.util.ArrayList;

public class Graph_SmallestSequesncePrime {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int a,b,c;
        a=b=c=0;
        for (int i = 0; i < D; i++) {
            int mA = res.get(a);
            int mB = res.get(b);
            int mC = res.get(c);
            int min = mA;
            min = Math.min(min, mB);
            min = Math.min(min, mC);

            res.add(min);
            if(min == mA)
                a++;

            if(min == mB)
                b++;

            if(min == mC)
                c++;
        }

        res.remove(0);
        return res;
    }
}
