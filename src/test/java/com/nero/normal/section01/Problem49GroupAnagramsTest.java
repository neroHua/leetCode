package com.nero.normal.section01;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem49GroupAnagramsTest {

    Problem49GroupAnagrams toBeTest = new Problem49GroupAnagrams();

    @Test
    public void test01() {
        String[] stringArray = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groupAnagrams = toBeTest.groupAnagrams(stringArray);
        List<List<String>> groupAnagramsExpected = new ArrayList<List<String>>();
        groupAnagramsExpected.add(Arrays.asList("bat"));
        groupAnagramsExpected.add(Arrays.asList("nat","tan"));
        groupAnagramsExpected.add(Arrays.asList("ate","eat","tea"));
        Assert.assertEquals(groupAnagramsExpected, groupAnagrams);
    }

    @Test
    public void test02() {
        String[] stringArray = {"abets","bead","remain","betas","abed","baste","airline","leading","beast","dealing","beats","airmen","marine","single","bade","aligned"};
        List<List<String>> groupAnagrams = toBeTest.groupAnagrams(stringArray);
        List<List<String>> groupAnagramsExpected = new ArrayList<List<String>>();
        groupAnagramsExpected.add(Arrays.asList("single"));
        groupAnagramsExpected.add(Arrays.asList("abets","baste","beast","beats","betas"));
        groupAnagramsExpected.add(Arrays.asList("abed","bade","bead"));
        groupAnagramsExpected.add(Arrays.asList("airmen","marine","remain"));
        groupAnagramsExpected.add(Arrays.asList("airline"));
        groupAnagramsExpected.add(Arrays.asList("aligned","dealing","leading"));
        Assert.assertEquals(groupAnagramsExpected, groupAnagrams);
    }
}