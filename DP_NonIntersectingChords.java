package com.crossover.demo;

public class DP_NonIntersectingChords {
    public static void main(String[] args) {
        System.out.println(chordCnt(5));
        System.out.println(chordCnt(6));
    }

    public static int chordCnt(int A) {
        long [] dp = new long[A+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=A;i++){

            for(int k=0;k<i;k++){
                dp[i]=(dp[i]+dp[k]*dp[i-1-k])%1000000007;
            }
        }

        return (int)dp[A];
    }
}
