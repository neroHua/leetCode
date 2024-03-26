package com.nero.normal.section01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Problem17LetterCombinationsOfAPhoneNumberTest {

    Problem17LetterCombinationsOfAPhoneNumber toBeTest = new Problem17LetterCombinationsOfAPhoneNumber();

    @Test
    public void test01() {
        List<String> stringListActual = toBeTest.letterCombinationsOfAPhoneNumber("23");
        List<String> stringListExpect = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        Assert.assertArrayEquals(stringListExpect.toArray(), stringListActual.toArray());
    }

    @Test
    public void test02() {
        List<String> stringListActual = toBeTest.letterCombinationsOfAPhoneNumber("");
        List<String> stringListExpect = Arrays.asList();
        Assert.assertArrayEquals(stringListExpect.toArray(), stringListActual.toArray());
    }

    @Test
    public void test03() {
        List<String> stringListActual = toBeTest.letterCombinationsOfAPhoneNumber("8");
        List<String> stringListExpect = Arrays.asList("t","u","v");
        Assert.assertArrayEquals(stringListExpect.toArray(), stringListActual.toArray());
    }
}
