package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem23MergeKSortedListsTest {

    Problem23MergeKSortedLists toBeTest = new Problem23MergeKSortedLists();

    @Test
    public void test01() {
        Problem23MergeKSortedLists.ListNode[] lists = new Problem23MergeKSortedLists.ListNode[3];
        lists[0] = toBeTest.new ListNode(2);
        lists[2] = toBeTest.new ListNode(-1);
        Problem23MergeKSortedLists.ListNode listNode = toBeTest.mergeKLists(lists);
        Assert.assertEquals(-1, listNode.val);
        Assert.assertEquals(2, listNode.next.val);
    }
}
