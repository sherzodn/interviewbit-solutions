package com.crossover.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_MergeKSortedList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(3);
        listNode1.next = listNode2;
        //listNode2.next = listNode3;
        listNode3.next = listNode4;
        //listNode4.next = listNode5;
        listNode5.next = listNode6;
        arrayList.add(listNode1);
        arrayList.add(listNode3);
        arrayList.add(listNode5);

        printListNode(mergeKLists(arrayList));
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : a) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode node = new ListNode(-1);
        ListNode curr = node;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            curr.next = new ListNode(temp.val);
            curr = curr.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return node.next;

    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


}
