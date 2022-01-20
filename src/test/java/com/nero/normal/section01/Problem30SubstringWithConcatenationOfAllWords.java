package com.nero.normal.section01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i]由小写英文字母组成
 *
 */
public class Problem30SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int wordCount = words.length;
        int wordsTotalLength = wordLength * wordCount;

        int quotient = s.length() / wordsTotalLength;
        if (quotient == 0) {
            return new LinkedList<>();
        }

        Map<String, Integer> wordsMap = initWordsMap(words);
        List<Integer> subStringIndex = new LinkedList<>();
        char[] sArray = s.toCharArray();
        Map<Integer, String> rememberSubStringMap = new HashMap<>();
        for (int i = 0; i <= sArray.length - wordsTotalLength; i++) {
            Map<String, Integer> wordsMapCopy = copyWordsMap(wordsMap);
            for (int j = i; j < wordsTotalLength + i; j += wordLength) {
                String jString = null;
                if (rememberSubStringMap.containsKey(j)) {
                    jString = rememberSubStringMap.get(j);
                }
                else {
                    jString = new String(sArray, j, wordLength);
                    rememberSubStringMap.put(j, jString);
                }
                if (wordsMapCopy.containsKey(jString)) {
                    Integer count = wordsMapCopy.get(jString);
                    count--;
                    if (count == 0) {
                        wordsMapCopy.remove(jString);
                    }
                    else {
                        wordsMapCopy.put(jString, count);
                    }
                }
                else {
                    break;
                }
            }
            if (wordsMapCopy.size() == 0) {
                subStringIndex.add(i);
            }
        }

        return subStringIndex;
    }

    private Map<String, Integer> initWordsMap(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (wordsMap.containsKey(words[i])) {
                Integer count = wordsMap.get(words[i]);
                wordsMap.put(words[i], count + 1);
            }
            else {
                wordsMap.put(words[i], 1);
            }
        }

        return wordsMap;
    }

    private Map<String, Integer> copyWordsMap(Map<String, Integer> wordsMap) {
        Map<String, Integer> copyWordsMap = new HashMap<>();
        for (String key : wordsMap.keySet()) {
            copyWordsMap.put(key, wordsMap.get(key));
        }
        return copyWordsMap;
    }

}
