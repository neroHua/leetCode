package com.nero.normal.section01;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 */
public class Problem32LongestValidParentheses {

    char[] sArray;

    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }

        sArray = s.toCharArray();
        return subLongestValidParentheses( 0, s.length() - 1);
    }

    private int subLongestValidParentheses(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (currentIsValidParentheses(start, end)) {
            return end - start + 1;
        }

        int sub1 = subLongestValidParentheses(start + 1, end);
        int sub2 = subLongestValidParentheses(start, end - 1);

        return sub1 > sub2 ? sub1 : sub2;
    }

    private boolean currentIsValidParentheses(int start, int end) {
        if ((end - start + 1) % 2 != 0) {
            return false;
        }
        if (')' == sArray[start]) {
            return false;
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            if ('(' == sArray[i]) {
                count++;
            }
            else {
                count--;
            }
            if (count == 0 && i < end) {
                if(currentIsValidParentheses(i + 1, end)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        return count == 0 ? true : false;
    }

}
