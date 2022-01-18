package com.nero.normal.section01;

public class Problem23MergeKSortedLists {

    private class ListNode {
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
        ListNode head = new ListNode();
        if (lists.length == 0) {
            return head;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        head = lists[0];

        for (int i = 0; i < lists.length - 1; i++) {
            head = mergeTwoList(lists[i], lists[i + 1]);
        }

        return head;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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

    boolean endOfBothListNode(ListNode l1, ListNode l2) {
        return null == l1 && null == l2;
    }
}
