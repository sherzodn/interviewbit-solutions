package com.crossover.demo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class HS_LargestContiniousZeros {
    public static void main(String[] args) {
        System.out.println(lszero(Arrays.asList( 1, 2, -3, 3)));
    }

    public static ArrayList<Integer> lszero(List<Integer> A) {
        ArrayList<Integer> sumList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        map.put(0,-1);

        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLen = -1;

        for (int i=0;i<A.size();i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                if (maxLen < (i - map.get(sum))) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLen = i - map.get(sum);
                }
            }
            else {
                map.put(sum, i);
            }
        }

        if(start >= 0 && end >= 0) {
            for(int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }

        return result;
    }

}
