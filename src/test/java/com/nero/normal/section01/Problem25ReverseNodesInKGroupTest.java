package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem25ReverseNodesInKGroupTest {

    Problem25ReverseNodesInKGroup toBeTest = new Problem25ReverseNodesInKGroup();

    @Test
    public void test01() {
        Problem25ReverseNodesInKGroup.ListNode head = toBeTest.new ListNode(1);
        Problem25ReverseNodesInKGroup.ListNode listNode = head;
        listNode.next = toBeTest.new ListNode(2);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(3);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(4);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(5);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(6);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(7);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(8);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(9);
        listNode = listNode.next;
        listNode.next = toBeTest.new ListNode(10);
        Problem25ReverseNodesInKGroup.ListNode reverseKGroupListNode = toBeTest.reverseKGroup(head, 4);
        Assert.assertEquals(4, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(3, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(2, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(1, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(8, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(7, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(6, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(5, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(9, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(10, reverseKGroupListNode.val);
    }

    @Test
    public void test02() {
        Problem25ReverseNodesInKGroup.ListNode head = toBeTest.new ListNode(1);
        Problem25ReverseNodesInKGroup.ListNode listNode = head;
        listNode.next = toBeTest.new ListNode(2);
        Problem25ReverseNodesInKGroup.ListNode reverseKGroupListNode = toBeTest.reverseKGroup(head, 2);
        Assert.assertEquals(2, reverseKGroupListNode.val);
        reverseKGroupListNode = reverseKGroupListNode.next;
        Assert.assertEquals(1, reverseKGroupListNode.val);
    }
}
