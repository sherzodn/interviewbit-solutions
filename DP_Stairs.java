package com.crossover.demo;

public class DP_Stairs {
    public static void main(String[] args) {
        int A = 30;
        long t1 = System.currentTimeMillis();
        System.out.println(climbStairs(A));
        System.out.println((System.currentTimeMillis() - t1) + " sec");
        t1 = System.currentTimeMillis();
        System.out.println(climbStairsWithLogN(A));
        System.out.println((System.currentTimeMillis() - t1) + " sec");
    }

    public static int climbStairs(int A) {
        int a = 1;
        int b = 1;
        int i = 2;
        while (i <= A) {
            int temp = a + b;
            a = b;
            b = temp;
            i++;
        }
        return b;
    }

    public static int climbStairsWithLogN(int A) {
        int n = A+1;
        int dp[] = new int[n+1];
        int res = steps(n, dp);
        return res;
    }

    private static int steps(int n, int[] dp) {
        //Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return (dp[n] = 1);
        //if dp[n] is already computed
        if (dp[n] != 0) {
            return dp[n];
        }
        int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;
        //
        dp[n] = (n & 1) == 1 ? (steps(k, dp) * steps(k, dp) + steps(k - 1, dp) * steps(k - 1, dp))
                : (2 * steps(k - 1, dp) + steps(k, dp)) * dp[k];
        return dp[n];
    }
}
