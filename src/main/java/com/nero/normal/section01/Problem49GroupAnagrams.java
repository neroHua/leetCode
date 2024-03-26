package com.nero.normal.section01;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 */
public class Problem49GroupAnagrams {

    /**
     *
     * @param originStringArray
     * @return
     */
    public List<List<String>> groupAnagrams(String[] originStringArray) {
        String[] orderStringArray = orderStringArray(originStringArray);

        Map<String, List<Integer>> orderStringGroupIndexMap = new HashMap<>(orderStringArray.length);
        for (int i = 0; i < orderStringArray.length; i++) {
            List<Integer> groupIndex = orderStringGroupIndexMap.containsKey(orderStringArray[i]) ? orderStringGroupIndexMap.get(orderStringArray[i]) : new LinkedList<>();
            groupIndex.add(i);
            orderStringGroupIndexMap.put(orderStringArray[i], groupIndex);
        }

        List<List<String>> groupAnagramList = new ArrayList<>();
        for (List<Integer> groupList : orderStringGroupIndexMap.values()) {
            List<String> groupAnagram = new LinkedList<>();
            for (int i = 0; i < groupList.size(); i++) {
                groupAnagram.add(originStringArray[groupList.get(i)]);
            }
            groupAnagramList.add(groupAnagram);
        }

        return groupAnagramList;
    }

    private String[] orderStringArray(String[] originStringArray) {
        String[] orderStringArray = new String[originStringArray.length];
        for (int i = 0; i < orderStringArray.length; i++) {
            orderStringArray[i] = orderString(originStringArray[i]);
        }
        return orderStringArray;
    }

    private String orderString(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        quickOrderCharArray(charArray, 0, charArray.length - 1);
        return new String(charArray);
    }

    private void quickOrderCharArray(char[] charArray, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start + 1;
        int j = end;

        char middle = charArray[start];
        while (i != j) {
            while (i < j) {
                if (charArray[i] > middle) {
                    swap(i, j, charArray);
                    j--;
                    break;
                }
                else {
                    i++;
                }
            }
            while (j > i) {
                if (charArray[j] < middle) {
                    swap(i, j, charArray);
                    i++;
                    break;
                }
                else {
                    j--;
                }
            }
        }

        if (charArray[i] < middle) {
            swap(i, start, charArray);
        }
        else {
            swap(i - 1, start, charArray);
            i = i - 1;
        }

        quickOrderCharArray(charArray, start, i - 1);
        quickOrderCharArray(charArray, i + 1, end);
    }

    private void swap(int i, int j, char[] charArray) {
        char tempChar = charArray[j];
        charArray[j] = charArray[i];
        charArray[i] = tempChar;
    }

//    public static void main(String[] args) {
//        Problem49GroupAnagrams problem49GroupAnagrams = new Problem49GroupAnagrams();
//        char[] charArray = "bead".toCharArray();
//        problem49GroupAnagrams.quickOrderCharArray(charArray, 0, charArray.length - 1);
//
//        System.out.println(charArray);
//    }
}
