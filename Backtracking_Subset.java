package com.crossover.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Backtracking_Subset {

    public static void main(String[] args) {
        ArrayList<Integer> input  = new ArrayList<>(Arrays.asList(3,1,2));
        System.out.println(subsets(input));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        if (A.size() == 0) return output;

        Collections.sort(A);
        generate(A, output, new ArrayList<>(), 0);

        return output;
    }

    private static void generate(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index){
        for (int i = index; i < A.size(); i++) {
            temp.add(A.get(i));
            System.out.println("i= "+i+"-------------------");
            System.out.print("temp ga A.get(i)="  + A.get(i)+ " qoshildi, temp=");
            System.out.println(temp);
            output.add(new ArrayList<>(temp));
            System.out.println("<<<< OUTPUT: " + output);
            generate(A, output, temp, i+1);
            System.out.println("temp dan " + temp.get(temp.size()-1) + " removed..");
            temp.remove(temp.size() - 1);
        }
    }


}
