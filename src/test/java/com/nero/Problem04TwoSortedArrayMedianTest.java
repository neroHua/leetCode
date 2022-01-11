package com.nero;

import org.junit.Assert;
import org.junit.Test;

public class Problem04TwoSortedArrayMedianTest {

    Problem04TwoSortedArrayMedian tobeTest = new Problem04TwoSortedArrayMedian();

    @Test
    public void testNum01() {
        int[] num = new int[] {1};

        double median = tobeTest.findMedianSortedArray(num);
        Assert.assertEquals(1.0, median, 0);
    }

    @Test
    public void testNum02() {
        int[] num = new int[] {1, 2};

        double median = tobeTest.findMedianSortedArray(num);
        Assert.assertEquals(1.5, median, 0);
    }

    @Test
    public void testNum03() {
        int[] num = new int[] {1, 2, 3};

        double median = tobeTest.findMedianSortedArray(num);
        Assert.assertEquals(2.0, median, 0);
    }

    @Test
    public void testNum04() {
        int[] num = new int[] {1, 2, 3, 4};

        double median = tobeTest.findMedianSortedArray(num);
        Assert.assertEquals(2.5, median, 0);
    }

    @Test
    public void testNums01() {
        int[] num1 = new int[] {1, 3};
        int[] num2 = new int[] {2};

        double median = tobeTest.findMedianSortedArray(num1, num2);
        Assert.assertEquals(2.0, median, 0);
    }

    @Test
    public void testNums02() {
        int[] num1 = new int[] {1, 2};
        int[] num2 = new int[] {3, 4};

        double median = tobeTest.findMedianSortedArray(num1, num2);
        Assert.assertEquals(2.5, median, 0);
    }

}
