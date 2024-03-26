package com.nero.normal.section01;

/**
 *有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 *
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 *
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 *
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.'
 *
 * 滑德友：
 * 前端编译问题：请参考javac，基本上读一遍就好了，有的时候需要探针向前探，这里的技术已经非常成熟了
 *
 */
public class Problem65ValidNumber {

    public boolean isNumber(String s) {
        if ('+' == s.charAt(0) || '-' == s.charAt(0)) {
            return isNumber(s, 1);
        }
        else {
            return isNumber(s, 0);
        }
    }

    private boolean isNumber(String s, int start) {
        if (start >= s.length()) {
            return false;
        }

        for (int i = start; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && '9' >= s.charAt(i)) {
                continue;
            }
            else if ('.' == s.charAt(i)) {
                return isDecimalNumber(s, i + 1);
            }
            else if ('e' == s.charAt(i) || 'E' == s.charAt(i)) {
                if (i == 0) {
                    return false;
                }
                else if (i == 1 && ('+' == s.charAt(0) || '-' == s.charAt(0))) {
                    return false;
                }
                return isPositiveOrNegativeInt(s, i + 1);
            }
            else {
                return false;
            }
        }

        return true;
    }

    private boolean isDecimalNumber(String s, int start) {
        if (start >= s.length()) {
            if (start == 1 && '.' == s.charAt(0)) {
                return false;
            }
            else if (start == 2 && ('+' == s.charAt(0) || '-' == s.charAt(0))) {
                return false;
            }
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && '9' >= s.charAt(i)) {
                continue;
            }
            else if ('e' == s.charAt(i) || 'E' == s.charAt(i)) {
                if (start == 1 && i == 1) {
                    return false;
                }
                else if (start == 2 && i == 2 && ('+' == s.charAt(0) || '-' == s.charAt(0))) {
                    return false;
                }
                return isPositiveOrNegativeInt(s, i + 1);
            }
            else {
                return false;
            }
        }

        return true;
    }

    private boolean isPositiveOrNegativeInt(String s, int start) {
        if (start >= s.length()) {
            return false;
        }

        if ('+' == s.charAt(start) || '-' == s.charAt(start)) {
            return isInt(s, start + 1);
        }
        else {
            return isInt(s, start);
        }
    }

    private boolean isInt(String s, int start) {
        if (start >= s.length()) {
            return false;
        }

        for (int i = start; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && '9' >= s.charAt(i)) {
                continue;
            }
            else {
                return false;
            }
        }

        return true;
    }

}
