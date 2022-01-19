package com.nero.normal.section01;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class Problem25ReverseNodesInKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        int size = calculateSize(head);
        int quotient = size / k;

        ListNode currentHead = head;
        ListNode currentNode = head;
        ListNode nextNode = head;

        for (int i = 0; i < k; i++) {
            ListNode tempNext = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tempNext;
        }
        head = currentNode;
        currentHead.next = nextNode;

        ListNode previousHead = currentHead;
        currentHead = nextNode;
        currentNode = nextNode;
        nextNode = null == nextNode ? null : nextNode.next;

        int i = 1;
        while (i < quotient) {
            for (int j = 1; j < k; j++) {
                ListNode tempNext = nextNode.next;
                nextNode.next = currentNode;
                currentNode = nextNode;
                nextNode = tempNext;
            }

            previousHead.next = currentNode;
            previousHead = currentHead;
            currentHead.next = nextNode;
            currentHead = nextNode;
            currentNode = nextNode;
            nextNode = null == nextNode ? null : nextNode.next;
            i++;
        }

        return head;
    }

    private int calculateSize(ListNode head) {
        int size = 1;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        return size;
    }

}
