package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem67AddBinaryTest {

    Problem67AddBinary toBeTest = new Problem67AddBinary();

    @Test
    public void test01() {
        Assert.assertEquals("10101", toBeTest.addBinary("1010", "1011"));
    }

    @Test
    public void test02() {
        Assert.assertEquals("0", toBeTest.addBinary("0", "0"));
    }
}
