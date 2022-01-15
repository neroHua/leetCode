package com.nero.normal.section01;

import com.nero.normal.section01.Problem03MaxSubStringLengthDoNotContainsDuplicateChar;
import org.junit.Assert;
import org.junit.Test;

public class Problem03MaxSubStringLengthDoNotContainsDuplicateCharTest {

    Problem03MaxSubStringLengthDoNotContainsDuplicateChar tobeTest = new Problem03MaxSubStringLengthDoNotContainsDuplicateChar();

    @Test
    public void test01() {
       String s = "pwwkew";
        int i = tobeTest.lengthOfLongestSubstring(s);
        Assert.assertEquals(i, 3);
    }

    @Test
    public void test02() {
        String s = "aab";
        int i = tobeTest.lengthOfLongestSubstring(s);
        Assert.assertEquals(i, 2);
    }

    @Test
    public void test03() {
        String s = "tmmzuxt";
        int i = tobeTest.lengthOfLongestSubstring(s);
        Assert.assertEquals(i, 5);
    }

}
