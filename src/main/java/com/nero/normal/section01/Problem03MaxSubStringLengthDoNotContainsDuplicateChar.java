package com.nero.normal.section01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Problem03MaxSubStringLengthDoNotContainsDuplicateChar {

    /**
     * O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> helpMap = new HashMap<>(256);

        int startIndex = 0;
        int endIndex = 0;

        int iterator = 0;
        int maxLength = 0;

        for (; iterator < s.length(); iterator++, endIndex++) {
            if (helpMap.containsKey(s.charAt(iterator))) {
                Integer duplicateIndex = helpMap.get(s.charAt(iterator));
                startIndex = duplicateIndex >= startIndex ? duplicateIndex + 1 : startIndex;
                helpMap.put(s.charAt(iterator), iterator);
            }
            else {
                helpMap.put(s.charAt(iterator), iterator);
            }
            maxLength = maxLength > endIndex - startIndex + 1 ? maxLength : endIndex - startIndex + 1;
        }

        return maxLength;
    }

}
