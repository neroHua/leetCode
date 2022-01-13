package com.nero;

import org.junit.Assert;
import org.junit.Test;

public class Problem07ReverseIntegerTest {

    Problem07ReverseInteger toBeTest = new Problem07ReverseInteger();

    @Test
    public void test01() {
        int reverse = toBeTest.reverse02(12345);
        Assert.assertEquals(54321, reverse);
    }

    @Test
    public void test02() {
        int reverse = toBeTest.reverse02(-12345);
        Assert.assertEquals(-54321, reverse);
    }

    @Test
    public void test03() {
        int reverse = toBeTest.reverse02(1534236469);
        Assert.assertEquals(0, reverse);
    }

}
