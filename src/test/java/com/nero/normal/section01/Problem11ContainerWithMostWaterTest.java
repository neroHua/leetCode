package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem11ContainerWithMostWaterTest {

    Problem11ContainerWithMostWater toBeTest = new Problem11ContainerWithMostWater();

    @Test
    public void test01() {
        Assert.assertEquals(49, toBeTest.maxArea02(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
