package com.nero.normal.section01;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 */
public class Problem58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && ' ' == s.charAt(i)) {
            i--;
        }
        while (i >= 0 && ' ' != s.charAt(i)) {
            i--;
            count++;
        }
        return count;
    }

}
