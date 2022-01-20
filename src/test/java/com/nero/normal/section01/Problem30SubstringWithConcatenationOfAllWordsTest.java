package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Problem30SubstringWithConcatenationOfAllWordsTest {

    Problem30SubstringWithConcatenationOfAllWords toBeTest = new Problem30SubstringWithConcatenationOfAllWords();

    @Test
    public void test01() {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(9);
        Assert.assertEquals(list, toBeTest.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
    }

    @Test
    public void test02() {
        List<Integer> list = new LinkedList<>();
        Assert.assertEquals(list, toBeTest.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"}));
    }

    @Test
    public void test03() {
        List<Integer> list = new LinkedList<>();
        list.add(6);
        list.add(9);
        list.add(12);
        Assert.assertEquals(list, toBeTest.findSubstring("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"}));
    }

    @Test
    public void test04() {
        List<Integer> list = new LinkedList<>();
        list.add(8);
        Assert.assertEquals(list, toBeTest.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "good"}));
    }
}
