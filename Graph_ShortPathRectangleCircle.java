package com.crossover.demo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph_ShortPathRectangleCircle {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListX = new ArrayList<>();
        arrayListX.add(2);
        ArrayList<Integer> arrayListY = new ArrayList<>();
        arrayListY.add(3);
        System.out.println(solve(2, 3, 1, 1, arrayListX, arrayListY));
    }

    public static String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int X[] = {0, 0, 1, 1, 1, -1, -1, -1};
        int Y[] = {1, -1, 0, 1, -1, 0, 1, -1};
        int[][] rect = new int[A+1][B+1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < C; k++) {
                    if (Math.sqrt((E.get(k) - i) * (E.get(k) - i) + (F.get(k) - j) * (F.get(k) - j)) <= D) {
                        rect[i][j] = 1;
                        break;
                    }
                }
            }
        }

        if (rect[0][0] == 1 || rect[A][B] == 1) return "NO";
        LinkedList<Pair> queue = new LinkedList<>();
        queue.push(new Pair(0, 0));
        while (!queue.isEmpty()) {
            int x = queue.peekFirst().x;
            int y = queue.peekFirst().y;
            queue.pop();
            if (x == A && y == B) return "YES";

            for (int i = 0; i < 8; i++) {
                int newX = x + X[i];
                int newY = y + Y[i];
                if (newX >= 0 && newX <= A && newY >= 0 && newY <= B && rect[newX][newY] == 0) {
                    rect[newX][newY] = 1;
                    queue.push(new Pair(newX, newY));
                }
            }

        }

        return "NO";
    }

    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
