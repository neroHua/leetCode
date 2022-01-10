package com.nero;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class Problem02TwoNumberAdd {

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

    /**
     * O(Max(l1.length, l2.length))
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l1) {
            return l2;
        }

        ListNode resultNode = new ListNode();

        ListNode iteratorCurrentResultNode = resultNode;
        ListNode iteratorNextResultNode = new ListNode();
        int iteratorOver = 0;

        while (true) {
            int iteratorSum = (null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + iteratorOver;

            int iteratorVal = iteratorSum % 10;
            iteratorCurrentResultNode.val = iteratorVal;
            iteratorCurrentResultNode.next = iteratorNextResultNode;

            iteratorOver = iteratorSum / 10;
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;

            if (endOfBothListNode(l1, l2)) {
                break;
            }

            iteratorCurrentResultNode = iteratorNextResultNode;
            iteratorNextResultNode = new ListNode();
        }

        if (iteratorOver > 0) {
            iteratorCurrentResultNode.next = new ListNode(iteratorOver);
        }
        else {
            iteratorCurrentResultNode.next = null;
        }

        return resultNode;
    }

    boolean endOfBothListNode(ListNode l1, ListNode l2) {
        return null == l1 && null == l2;
    }
}
