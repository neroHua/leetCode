package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem32LongestValidParenthesesTest {

    Problem32LongestValidParentheses toBeTest = new Problem32LongestValidParentheses();

    @Test
    public void test01() {
        Assert.assertEquals(0, toBeTest.longestValidParentheses(")("));
    }

    @Test
    public void test02() {
        Assert.assertEquals(2, toBeTest.longestValidParentheses("(()"));
    }

    @Test
    public void test03() {
        Assert.assertEquals(4, toBeTest.longestValidParentheses(")()())"));
    }

    @Test
    public void test04() {
        Assert.assertEquals(0, toBeTest.longestValidParentheses(""));
    }

    @Test
    public void test05() {
        Assert.assertEquals(4, toBeTest.longestValidParentheses(")()())()()("));
    }

    @Test
    public void test06() {
        // 这测试跑了一夜也没有跑完，结果不知道，超出了leetCode的时间限制
        // 从递归的方式中又表明了做了一些重复计算。考虑使用动态规划加快速度
        Assert.assertEquals(4, toBeTest.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
    }
}
