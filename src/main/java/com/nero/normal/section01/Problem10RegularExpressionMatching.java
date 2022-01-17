package com.nero.normal.section01;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只含小写英文字母。
 * p 只含小写英文字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 */
public class Problem10RegularExpressionMatching {

    private char[] sArray;
    private char[] pArray;
    private int[][] helpArray;

    public boolean isMatch(String s, String p) {
        sArray = s.toCharArray();
        pArray = p.toCharArray();

        return subMatch(0, 0);
    }

    private boolean subMatch(int i, int j) {
        if (i >= sArray.length && j >= pArray.length) {
            return true;
        }
        else if (i >= sArray.length && j <= pArray.length - 2) {
            for (; j <= pArray.length - 2; j += 2) {
                if ('*' != pArray[j + i]) {
                    return false;
                }
            }
            if ('*' != pArray[pArray.length - 1]) {
                return false;
            }
            return true;
        }
        else if (i >= sArray.length && j == pArray.length - 1) {
            return false;
        }
        else if (i < sArray.length && j >= pArray.length) {
            return false;
        }

        if (j + 1 < pArray.length && '*' == pArray[j + 1]) {
            for (int m = i; m < sArray.length; m++) {
                if ('.' == pArray[j] || sArray[m] == pArray[j]) {
                    if (subMatch(m + 1, j + 2)) {
                        return true;
                    }
                    if (subMatch(m, j + 2)) {
                        return true;
                    }
                    if (subMatch(m + 1, j)) {
                        return true;
                    }
                }
                else {
                    if (subMatch(m, j + 2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        else {
            if ('.' == pArray[j] || sArray[i] == pArray[j]) {
                return subMatch(i + 1, j + 1);
            }
        }

        return false;
    }

    public boolean isMatch02(String s, String p) {
        sArray = s.toCharArray();
        pArray = p.toCharArray();
        helpArray = new int[sArray.length + 1][pArray.length + 2];

        return subMatch02(0, 0);
    }

    private boolean subMatch02(int i, int j) {
        if (helpArray[i][j] != 0) {
            return helpArray[i][j] == 1 ? false : true;
        }

        System.out.println(i + "\t" + j);
        if (i >= sArray.length && j >= pArray.length) {
            helpArray[i][j] = 1;
            return true;
        }
        else if (i >= sArray.length && j <= pArray.length - 2) {
            for (; j <= pArray.length - 2; j += 2) {
                if ('*' != pArray[j + i]) {
                    helpArray[i][j] = 2;
                    helpArray[i][j + 1] = 2;
                    return false;
                }
                helpArray[i][j] = 1;
                helpArray[i][j + 1] = 1;
            }
            if ('*' != pArray[pArray.length - 1]) {
                helpArray[i][pArray.length - 1] = 1;
                return false;
            }
            return true;
        }
        else if (i >= sArray.length && j == pArray.length - 1) {
            helpArray[i][j] = 1;
            return false;
        }
        else if (i < sArray.length && j >= pArray.length) {
            helpArray[i][j] = 1;
            return false;
        }

        if (j + 1 < pArray.length && '*' == pArray[j + 1]) {
            for (int m = i; m < sArray.length; m++) {
                if ('.' == pArray[j] || sArray[m] == pArray[j]) {
                    helpArray[m][j] = 2;
                    if (subMatch02(m + 1, j + 2)) {
                        return true;
                    }
                    if (subMatch02(m, j + 2)) {
                        return true;
                    }
                    if (subMatch02(m + 1, j)) {
                        return true;
                    }
                }
                else {
                    if (subMatch02(m, j + 2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        else {
            if ('.' == pArray[j] || sArray[i] == pArray[j]) {
                helpArray[i][j] = 2;
                return subMatch02(i + 1, j + 1);
            }
        }

        helpArray[i][j] = 1;
        return false;
    }

    public static void main(String[] args) {
        Problem10RegularExpressionMatching tobeTest = new Problem10RegularExpressionMatching();
        tobeTest.isMatch02("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
        System.out.println("aaaaaaaaaaaaab".length());
        System.out.println("a*a*a*a*a*a*a*a*a*a*c".length());
    }

}
