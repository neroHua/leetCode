package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem44WildcardMatchingTest {

    Problem44WildcardMatching toBeTest = new Problem44WildcardMatching();

    @Test
    public void test01() {
        boolean match = toBeTest.isMatch("", "*******");
        Assert.assertTrue(match);
    }

    @Test
    public void test02() {
        boolean match = toBeTest.isMatch("", "");
        Assert.assertTrue(match);
    }

    @Test
    public void test03() {
        boolean match = toBeTest.isMatch("", "ab*");
        Assert.assertFalse(match);
    }

    @Test
    public void test04() {
        boolean match = toBeTest.isMatch("b", "*?*?*");
        Assert.assertFalse(match);
    }

    @Test
    public void test05() {
        boolean match = toBeTest.isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b");
        Assert.assertFalse(match);
    }

    @Test
    public void test06() {
        boolean match = toBeTest.isMatch("bbaabaabbabababbaababbaaabbbaaab", "*bba*a*bbba*aab*b");
        Assert.assertFalse(match);
    }

    @Test
    public void test07() {
        boolean match = toBeTest.isMatch("adceb", "*a*b");
        Assert.assertTrue(match);
    }

    @Test
    public void test08() {
        boolean match = toBeTest.isMatch("abcabczzzde", "*abc???de*");
        Assert.assertTrue(match);
    }

    @Test
    public void test09() {
        boolean match = toBeTest.isMatch("acdcb", "a*c?b");
        Assert.assertFalse(match);
    }

    @Test
    public void test10() {
        boolean match = toBeTest.isMatch("mississippi", "m??*ss*?i*pi");
        Assert.assertFalse(match);
    }

    @Test
    public void test11() {
        boolean match = toBeTest.isMatch("abcabczzzde", "*abc???de*");
        Assert.assertTrue(match);
    }

    @Test
    public void test12() {
        boolean match = toBeTest.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");
        Assert.assertTrue(match);
    }

    @Test
    public void test13() {
        boolean match = toBeTest.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*b*aba*babaa*bbaba*a*aaba*b*aa*a*b*ba*a*a*");
        Assert.assertTrue(match);
    }

    @Test
    public void test14() {
        boolean match = toBeTest.isMatch("abbbaaababbaaabaaabbbabbbbaaabbaaababaabbbbbbaababbabababbababaaabbbbbabababaababaaaaaaabbbaabaabbbaabbabaababbabaababbbabbaaabbbaaaababbaaabbaabaabbbbbaaababaabaabaaabbabaabbbabbbaabbababaabbbbbbbbaaa", "*ba***bba*b**abbaa***a*****b*a*bb*b***a*bbb***a***bba*****a****a*a*b**aaaba*aab*a*aa***a*a*b**b**a*b*");
        Assert.assertTrue(match);
    }

    @Test
    public void test15() {
        boolean match = toBeTest.isMatch("a", "");
        Assert.assertFalse(match);
    }

}

