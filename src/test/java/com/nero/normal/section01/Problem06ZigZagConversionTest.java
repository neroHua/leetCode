package com.nero.normal.section01;

import com.nero.normal.section01.Problem06ZigZagConversion;
import org.junit.Assert;
import org.junit.Test;

public class Problem06ZigZagConversionTest {

    Problem06ZigZagConversion toBeTest = new Problem06ZigZagConversion();

    @Test
    public void test01() {
        String s = toBeTest.convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", s);
    }

    @Test
    public void test02() {
        String s = toBeTest.convert("abcdefg", 2);
        Assert.assertEquals("acegbdf", s);
    }

    @Test
    public void test03() {
        String s = toBeTest.convert("abcd", 3);
        Assert.assertEquals("adbc", s);
    }

}
