package com.nero.normal.section01;

public class Problem23MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoList(head, lists[i]);
        }

        return head;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            l2 = l2.next;
        }

        ListNode iteratorCurrentNode = head;
        while (true) {
            if (null == l1) {
                iteratorCurrentNode.next = l2;
                break;
            }
            else if (null == l2) {
                iteratorCurrentNode.next = l1;
                break;
            }
            else if (l1.val < l2.val) {
                iteratorCurrentNode.next = l1;
                l1 = l1.next;
            }
            else {
                iteratorCurrentNode.next = l2;
                l2 = l2.next;
            }

            iteratorCurrentNode = iteratorCurrentNode.next;
        }

        return head;
    }

}
