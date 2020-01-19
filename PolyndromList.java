package com.crossover.demo;

public class PolyndromList {
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
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode4;
        listNode4.next = listNode5;
        long time1 = System.nanoTime();
        printListNode(mergeTwoLists(listNode1, listNode4));
        System.out.println(System.nanoTime() - time1);
        time1 = System.nanoTime();
        printListNode(mergeTwoLists2(listNode1, listNode4));
        System.out.println(System.nanoTime() - time1);
        //System.out.println(lPalin(listNode1));
        //printListNode(deleteDuplicates2(listNode1));

    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (A != null && B != null) {
            if (A.val > B.val) {
                curr.next = new ListNode(B.val);
                B = B.next;
            } else {
                curr.next = new ListNode(A.val);
                A = A.next;
            }
            curr = curr.next;
        }

        while (A != null) {
            curr.next = new ListNode(A.val);
            A = A.next;
            curr = curr.next;
        }

        while (B != null) {
            curr.next = new ListNode(B.val);
            B = B.next;
            curr = curr.next;
        }

        return result.next;
    }

    //second solution
    public static ListNode mergeTwoLists2(ListNode A, ListNode B) {
        final ListNode head =  new ListNode(0);
        ListNode prev = head;
        while (A != null || B != null) {
            boolean moveA = (B == null) || (A != null && A.val <= B.val);
            if (moveA) {
                prev.next = A;
                A = A.next;
            } else {
                prev.next = B;
                B = B.next;
            }
            prev = prev.next;
            prev.next = null;
        }
        return head.next;
    }


    //Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return A;
    }

    //Remove Duplicates from Sorted List II
    public static ListNode deleteDuplicates2(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode helper = new ListNode(Integer.MIN_VALUE);
        helper.next = A;
        ListNode prev = helper;
        ListNode curr = A;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (curr.val == next.val) {
                while (curr.next != null && curr.val == next.val) {
                    curr = curr.next;
                    next = next.next;
                }
                prev.next = next;
                curr = next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return helper.next;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static int lPalin(ListNode head) {
        if (head == null || head.next == null) return 1;
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int i = 1;
        curr = head;

        while (i < size / 2) {
            curr = curr.next;
            i++;
        }
        ListNode mid = reverse(curr.next);
        curr = head;
        while (mid != null) {
            if (curr.val != mid.val) return 0;
            curr = curr.next;
            mid = mid.next;
        }
        return 1;
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
}
