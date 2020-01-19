package com.crossover.demo;

import java.util.*;

public class Graph_LevelOrder {

    static class TreeNode {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
        //this 3thd is the optimal solution
        System.out.println(levelOrder3(root));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        int h = height(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= h; i++) {
            res.add(getCurrentLevelElements(i, A, new ArrayList<>()));
        }

        return res;
    }

    private static ArrayList<Integer> getCurrentLevelElements(int level, TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        if (level == 1) {
            list.add(root.val);
        } else if (level > 1) {
            getCurrentLevelElements(level - 1, root.left, list);
            getCurrentLevelElements(level - 1, root.right, list);

        }
        return list;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftH = height(root.left);
            int rightH = height(root.right);
            if (leftH > rightH) {
                return leftH + 1;
            } else {
                return rightH + 1;
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int h = height(A);
        for (int i = 0; i < h; i++) {
            res.add(new ArrayList<>());
        }
        queue.add(new Pair(A, 1));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            res.get(temp.levelNum - 1).add(temp.node.val);
            if (temp.node.left != null) {
                queue.add(new Pair(temp.node.left, temp.levelNum + 1));
            }
            if (temp.node.right != null) {
                queue.add(new Pair(temp.node.right, temp.levelNum + 1));
            }
        }
        return res;
    }

    static class Pair {
        private TreeNode node;
        private int levelNum;

        public Pair(TreeNode node, int levelNum) {
            this.node = node;
            this.levelNum = levelNum;
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder3(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> list  = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(list);
        }

        return res;
    }

}
