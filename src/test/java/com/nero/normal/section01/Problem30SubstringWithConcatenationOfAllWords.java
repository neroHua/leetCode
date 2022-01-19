package com.nero.normal.section01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 */
public class Problem30SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> helpMap = new HashMap<>();
        int wordLength = words[0].length();

        for (int i = 0; i < s.length()) {

        }

        return null;
    }

    public Map<String, Integer> initHelpMap(String[] words) {
        Map<String, Integer> helpMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (helpMap.containsKey(words[i])) {
                Integer count = helpMap.get(words[i]);
                helpMap.put(words[i], count + 1);
            }
            else {
                helpMap.put(words[i], 1);
            }
        }

        return helpMap;
    }

}
