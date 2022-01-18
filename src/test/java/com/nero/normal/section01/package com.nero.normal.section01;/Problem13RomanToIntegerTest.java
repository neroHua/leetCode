package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem13RomanToIntegerTest {

    Problem13RomanToInteger toBeTest = new Problem13RomanToInteger();

    @Test
    public void test01() {
        Assert.assertEquals(3, toBeTest.romanToInt("III"));
    }

    @Test
    public void test02() {
        Assert.assertEquals(4, toBeTest.romanToInt("IV"));
    }

    @Test
    public void test03() {
        Assert.assertEquals(9, toBeTest.romanToInt("IX"));
    }

    @Test
    public void test04() {
        Assert.assertEquals(58, toBeTest.romanToInt("LVIII"));
    }

    @Test
    public void test05() {
        Assert.assertEquals(1994, toBeTest.romanToInt("MCMXCIV"));
    }

    @Test
    public void test06() {
        Assert.assertEquals(6, toBeTest.romanToInt("VI"));
    }
}
