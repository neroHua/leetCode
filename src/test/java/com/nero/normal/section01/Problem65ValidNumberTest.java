package com.nero.normal.section01;
import org.junit.Assert;
import org.junit.Test;

public class Problem65ValidNumberTest {

    Problem65ValidNumber toBeTest = new Problem65ValidNumber();

    @Test
    public void test01() {
        Assert.assertTrue(toBeTest.isNumber("2e0"));
    }

    @Test
    public void test02() {
        Assert.assertFalse(toBeTest.isNumber("e9"));
    }

    @Test
    public void test03() {
        Assert.assertFalse(toBeTest.isNumber(".e1"));
    }

    @Test
    public void test04() {
        Assert.assertFalse(toBeTest.isNumber("+e1"));
    }

    @Test
    public void test05() {
        Assert.assertTrue(toBeTest.isNumber(".0e7"));
    }

    @Test
    public void test06() {
        Assert.assertFalse(toBeTest.isNumber("+.e3"));
    }
}
