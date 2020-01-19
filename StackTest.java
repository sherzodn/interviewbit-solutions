package com.crossover.demo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
//        System.out.println(braces("((a+b)+b)"));
//        System.out.println(braces("((a+b))+b"));
        //      System.out.println(prevSmaller(Arrays.asList(4,5,2,10,8)));
              System.out.println(nextGreater(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1)));
//        System.out.println(largestRectangleArea2(Arrays.asList(2, 1, 5, 6, 2, 3)));
    }

    /*Input : [4, 5, 2, 10]
     Output : [5, 10, 10, -1]*/
    public static ArrayList<Integer> nextGreater(List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        for (int i=n-1; i>=0; i--) {
           while (!stack.isEmpty() && A.get(i) >= stack.peek()){
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans.add(0, -1);
            } else {
                ans.add(0, stack.peek());
            }

            stack.add(A.get(i));
        }

        return ans;
    }


    /* Input: [2, 1, 5, 6, 2, 3]
       Output: 10
       */
    // this is O(n^2) solution
    public static int largestRectangleArea(List<Integer> A) {
        int maxRectArea = 0;
        int heigh = 0;
        int left, right = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            heigh = A.get(i);
            left = i;
            right = i;
            while (left >= 0 && A.get(left) >= heigh) {
                left--;
            }
            while (right < n && A.get(right) >= heigh) {
                right++;
            }
            maxRectArea = Math.max(maxRectArea, (right - left - 1) * heigh);
        }

        return maxRectArea;
    }

    /* Input: [2, 1, 5, 6, 2, 3]
           i   0  1  2  3  4  5
      Output: 10
      */
    // this is O(n) solution
    public static int largestRectangleArea2(List<Integer> A) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
        int n = A.size();
        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || A.get(s.peek()) <= A.get(i))
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = A.get(tp) * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty()) {
            tp = s.peek();
            s.pop();
            area_with_top = A.get(tp) * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    /*
    * Input 1:
    A = [4, 5, 2, 10, 8]
    Output 1:
    G = [-1, 4, -1, 2, 2]
*/
    public static ArrayList<Integer> prevSmaller(List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : A) {
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }

            stack.add(num);
        }

        return result;
    }

    public static String simplifyPath(String A) {
        String[] parts = A.trim().split("/");

        Stack<String> stack = new Stack<>();
        for (String s : parts) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder("");
        while (!stack.empty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, "/");
        }

        return builder.length() != 0 ? builder.toString() : "/";
    }

    public static int braces(String A) {
        char[] chars = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == ')') {
                char top = stack.pop();
                if (top == '(') {
                    return 1;
                } else {
                    int count = 0;
                    while (!stack.isEmpty() && top != '(') {
                        top = stack.pop();
                        count++;
                    }
                    if (count == 1) return 1;
                }
            } else {
                stack.push(ch);
            }
        }
        return 0;
    }


}
