package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem09PalindromeNumberTest {

    Problem09PalindromeNumber toBeTest = new Problem09PalindromeNumber();

    @Test
    public void test01() {
        Assert.assertEquals(true, toBeTest.isPalindrome(121));
    }

}
