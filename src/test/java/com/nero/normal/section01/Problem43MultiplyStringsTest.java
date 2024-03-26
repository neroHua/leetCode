package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem43MultiplyStringsTest {

    Problem43MultiplyStrings toBeTest = new Problem43MultiplyStrings();

    @Test
    public void test01() {
        String s = toBeTest.multiply("2", "3");
        Assert.assertEquals("6", s);
    }

    @Test
    public void test02() {
        String s = toBeTest.multiply("123", "456");
        Assert.assertEquals("56088", s);
    }

    @Test
    public void test03() {
        String s = toBeTest.multiply("0", "0");
        Assert.assertEquals("0", s);
    }
}
