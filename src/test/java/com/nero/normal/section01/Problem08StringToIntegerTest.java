package com.nero.normal.section01;

import com.nero.normal.section01.Problem08StringToInteger;
import org.junit.Assert;
import org.junit.Test;

public class Problem08StringToIntegerTest {

    Problem08StringToInteger toBeTest = new Problem08StringToInteger();

    @Test
    public void test01() {
        Assert.assertEquals(42, toBeTest.myAtoi("42"));
    }

    @Test
    public void test02() {
        Assert.assertEquals(-42, toBeTest.myAtoi("-42"));
    }

    @Test
    public void test03() {
        Assert.assertEquals(0, toBeTest.myAtoi("words and 987"));
    }

    @Test
    public void test04() {
        Assert.assertEquals(0, toBeTest.myAtoi("+-12"));
    }

    @Test
    public void test05() {
        Assert.assertEquals(0, toBeTest.myAtoi(" "));
    }

    @Test
    public void test06() {
        Assert.assertEquals(2147483647, toBeTest.myAtoi("2147483648"));
    }
}
