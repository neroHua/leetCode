package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem20ValidParenthesesTest {

    Problem20ValidParentheses toBeTest = new Problem20ValidParentheses();

    @Test
    public void test01() {
        boolean actualValid = toBeTest.isValid("([)]");
        Assert.assertFalse(actualValid);
    }

    @Test
    public void test02() {
        boolean actualValid = toBeTest.isValid("()");
        Assert.assertTrue(actualValid);
    }

    @Test
    public void test03() {
        boolean actualValid = toBeTest.isValid("()[]{}");
        Assert.assertTrue(actualValid);
    }
}

