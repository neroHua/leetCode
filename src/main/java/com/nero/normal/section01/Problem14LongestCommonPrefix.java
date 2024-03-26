package com.nero.normal.section01;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 */
public class Problem14LongestCommonPrefix {

    public String longestCommonPrefix(String[] stringArray) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < stringArray.length; i++) {
            minLength = stringArray[i].length() < minLength ? stringArray[i].length() : minLength;
        }

        int maxSameCharFrom0Index = 0;
        for (int i = 0; i < minLength; i++) {
            char iIndexChar = stringArray[0].charAt(i);
            boolean iIndexCharSame = Boolean.TRUE;

            for (int j = 1; j < stringArray.length; j++) {
                if (iIndexChar != stringArray[j].charAt(i)) {
                    iIndexCharSame = Boolean.FALSE;
                    break;
                }
            }

            if (iIndexCharSame) {
                maxSameCharFrom0Index++;
            }
            else {
                break;
            }
        }

        return new String(stringArray[0].toCharArray(), 0, maxSameCharFrom0Index);
    }

}
