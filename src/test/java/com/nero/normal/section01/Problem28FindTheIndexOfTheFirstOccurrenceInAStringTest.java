package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

public class Problem28FindTheIndexOfTheFirstOccurrenceInAStringTest {

    Problem28FindTheIndexOfTheFirstOccurrenceInAString toBeTest = new Problem28FindTheIndexOfTheFirstOccurrenceInAString();

    @Test
    public void test01() {
        int index = toBeTest.strStr("a", "a");
        Assert.assertEquals(0, index);
    }
}
