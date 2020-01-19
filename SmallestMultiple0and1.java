package com.crossover.demo;

import java.math.BigInteger;
import java.util.*;

public class SmallestMultiple0and1 {
    public static void main(String[] args) {
        System.out.println(multiple(9));
        System.out.println(multiple2(9));
        System.out.println(multiple3(9));
        System.out.println(multiple(3));
        System.out.println(multiple2(3));
        System.out.println(multiple3(3));
        System.out.println(multiple(5));
        System.out.println(multiple2(5));
        System.out.println(multiple3(5));
    }

    public static String multiple(int A) {
        if (A == 0) return "0";
        if (isNumberBinary(A)) return String.valueOf(A);
        Deque<String> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer("1");
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            int modNum = mod(temp, A);
            if (modNum == 0) {
                return temp;
            } else if (!set.contains(modNum)) {
                queue.offer(temp + "0");
                queue.offer(temp + "1");
                set.add(modNum);
            }
        }
        return "";
    }

    public static boolean isNumberBinary(int N) {
        int mod = 0;
        while (N > 0) {
            mod = N % 10;
            if (mod > 1) return false;
            N /= 10;
        }
        return true;
    }

    private static int mod(String s, int N) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = r * 10 + (s.charAt(i) - '0');
            r %= N;
        }

        return r;
    }

    public static String multiple2(int A) {
        // if (isNumberBinary(A)) return String.valueOf(A);
        Set<Integer> set = new HashSet<>();
        if (A == 0) return "0";
        Deque<BigInteger> queue = new LinkedList<>();
        queue.add(BigInteger.ONE);
        BigInteger modNum;
        while (!queue.isEmpty()) {
            BigInteger temp = queue.poll();
            modNum = temp.mod(BigInteger.valueOf(A));
            if (modNum.equals(BigInteger.ZERO)) return String.valueOf(temp);
            if (!set.contains(modNum.intValue())) {
                queue.add(temp.multiply(BigInteger.TEN));
                queue.add(temp.multiply(BigInteger.TEN).add(BigInteger.ONE));
            }
        }

        return "";
    }

    public static String multiple3(int A) {
        if (A == 0) return "0";
        boolean[] isVisited = new boolean[A];
        String result = "0";
        //The queue used by BFS
        Queue<Node> queue = new ArrayDeque<>();
        // Add first number 1 and mark it visited
        queue.add(new Node(true, 1 % A, null));
        isVisited[1 % A] = true;

        //The final destination node which represents the answer
        Node destNode = null;

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            if (currNode.val == 0) {
                // we have reached a valid multiple of A
                destNode = currNode;
                break;
            } else {
                // visit the next 2 neighbours
                //append 0 - (currNode.val*10)
                //append 1 - (currNode.val*10 + 1)

                //append '0'
                int val1 = (currNode.val * 10) % A;
                if (!isVisited[val1]) {
                    queue.add(new Node(false, val1, currNode));
                    isVisited[val1] = true;
                }

                //append '1'
                int val2 = val1 + 1;
                if (val2 == A) {
                    val2 = 0;
                }
                if (!isVisited[val2]) {
                    queue.add(new Node(true, val2, currNode));
                    isVisited[val2] = true;
                }
            }
        }

        // trace the path from destination to source
        if (destNode != null) {
            StringBuilder reversRes = new StringBuilder();
            Node currNode = destNode;
            while (currNode != null) {
                reversRes.append(currNode.isDigitOne ? '1' : '0');
                currNode = currNode.prev;
            }
            result = reversRes.reverse().toString();

        }
        return result;
    }

    private static class Node {
        private final boolean isDigitOne;
        public final int val;
        public final Node prev;

        public Node(boolean isDigitOne, int val, Node prev) {
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.prev = prev;
        }
    }
}
