package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem12IntegerToRomanTest {

    Problem12IntegerToRoman toBeTest = new Problem12IntegerToRoman();

    @Test
    public void test01() {
        Assert.assertEquals("III", toBeTest.intToRoman(3));
    }

    @Test
    public void test02() {
        Assert.assertEquals("IV", toBeTest.intToRoman(4));
    }

    @Test
    public void test03() {
        Assert.assertEquals("IX", toBeTest.intToRoman(9));
    }

    @Test
    public void test04() {
        Assert.assertEquals("LVIII", toBeTest.intToRoman(58));
    }

    @Test
    public void test05() {
        Assert.assertEquals("MCMXCIV", toBeTest.intToRoman(1994));
    }

    @Test
    public void test06() {
        Assert.assertEquals("VI", toBeTest.intToRoman(6));
    }
}
