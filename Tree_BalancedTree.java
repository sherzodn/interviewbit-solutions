package com.crossover.demo;

public class Tree_BalancedTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

    }

    public int isBalanced(TreeNode A) {
        if (A == null) return 1;
        if (Math.abs(height(A.right) - height(A.left)) > 1) return 0;
        return Math.min(isBalanced(A.left), isBalanced(A.right));
    }

    public int height(TreeNode A){
        if (A==null) return 0;
        return 1 + Math.max(height(A.left), height(A.right));
    }
}
