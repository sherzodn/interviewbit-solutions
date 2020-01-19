package com.crossover.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_IdenticalTrees {
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

    public static int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return 1;
        }
        if (a == null || b == null) {
            return 0;
        }
        if (a.val != b.val) {
            return 0;
        }
        return isSameTree(a.right, b.right) & isSameTree(a.left, b.left);
    }

    //solution with Queue - iterative method
    public static int isSymmetric(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A.left);
        queue.add(A.right);
        while (!queue.isEmpty()) {
            TreeNode tempLeft = queue.remove();
            TreeNode tempRight = queue.remove();
            if (tempLeft == null && tempRight == null) {
                continue;
            }

            if ((tempLeft == null && tempRight != null) || (tempLeft != null && tempRight == null)) return 0;
            if (tempLeft.val != tempRight.val) return 0;

            queue.add(tempLeft.left);
            queue.add(tempRight.right);
            queue.add(tempLeft.right);
            queue.add(tempRight.left);
        }
        return 1;
    }

    // this is second solution which is used recursive method
    public int isSymmetric2(TreeNode A) {
        return isSymmetric(A.left, A.right) ? 1 : 0;
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
