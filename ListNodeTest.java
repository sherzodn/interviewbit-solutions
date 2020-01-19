package com.crossover.demo;

public class ListNodeTest {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        printListNode(subtract(listNode1));
    }

    public static ListNode subtract(ListNode A) {
       ListNode curr = A;
       ListNode slow = A;
       ListNode fast = slow.next;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }

       ListNode temp = reverse(slow.next);
       ListNode secondHalf = temp;
       while (curr != null && secondHalf != null) {
           curr.val = secondHalf.val - curr.val;
           curr = curr.next;
           secondHalf = secondHalf.next;
       }

       reverse(temp);
       return A;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


}
