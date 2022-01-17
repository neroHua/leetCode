package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem10RegularExpressionMatchingTest {

    Problem10RegularExpressionMatching toBeTest = new Problem10RegularExpressionMatching();

    @Test
    public void test01() {
        Assert.assertFalse(toBeTest.isMatch("aaaa", "a"));
    }

    @Test
    public void test02() {
        Assert.assertTrue(toBeTest.isMatch("aaaa", "a*"));
    }

    @Test
    public void test03() {
        Assert.assertTrue(toBeTest.isMatch("ab", ".*"));
    }

    @Test
    public void test04() {
        Assert.assertTrue(toBeTest.isMatch("aab", "c*a*b*"));
    }

    @Test
    public void test05() {
        Assert.assertTrue(toBeTest.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test06() {
        Assert.assertTrue(toBeTest.isMatch("ab", "a*b"));
    }

    @Test
    public void test07() {
        Assert.assertTrue(toBeTest.isMatch("a", "ab*"));
    }

    @Test
    public void test08() {
        Assert.assertFalse(toBeTest.isMatch("ab", ".*c"));
    }

    @Test
    public void test09() {
        Assert.assertFalse(toBeTest.isMatch("a", "ab*a"));
    }

    @Test
    public void test10() {
        // 这测试用显示用了5分钟左右，虽然最终结果通过了，但是太耗时了，超出了leetCode的时间限制
        // 从递归的方式中又表明了做了一些重复计算。考虑使用动态规划加快速度
        Assert.assertFalse(toBeTest.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }

    @Test
    public void test11() {
        Assert.assertFalse(toBeTest.isMatch02("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }

    @Test
    public void test12() {
        Assert.assertFalse(toBeTest.isMatch02("mississippi", "mis*is*p*."));
    }

    @Test
    public void test13() {
        Assert.assertFalse(toBeTest.isMatch02("bb", ".bab"));
    }

    @Test
    public void test14() {
        Assert.assertTrue(toBeTest.isMatch02("ab", ".*..c*"));
    }

    @Test
    public void test15() {
        Assert.assertFalse(toBeTest.isMatch02("ab", ".*c"));
    }

    @Test
    public void test16() {
        Assert.assertFalse(toBeTest.isMatch02("a", ".*..a*"));
    }
}
