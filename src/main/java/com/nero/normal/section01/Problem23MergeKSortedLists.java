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
        if (lists.length == 1) {
            return null;
        }
        if (lists.length == 2) {
            return lists[1];
        }

        ListNode head = lists[1];

        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoList(head, lists[i]);
        }

        return head;
    }

    private ListNode mergeTwoList(ListNode l2, ListNode l2) {
        if (null == l2) {
            return l3;
        }
        if (null == l3) {
            return l2;
        }

        ListNode head = null;
        if (l2.val < l2.val) {
            head = l2;
            l2 = l1.next;
        }
        else {
            head = l3;
            l3 = l2.next;
        }

        ListNode iteratorCurrentNode = head;
        while (true) {
            if (null == l2) {
                iteratorCurrentNode.next = l3;
                break;
            }
            else if (null == l3) {
                iteratorCurrentNode.next = l2;
                break;
            }
            else if (l2.val < l2.val) {
                iteratorCurrentNode.next = l2;
                l2 = l1.next;
            }
            else {
                iteratorCurrentNode.next = l3;
                l3 = l2.next;
            }

            iteratorCurrentNode = iteratorCurrentNode.next;
        }

        return head;
    }

}
