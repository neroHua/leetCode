package com.nero.normal.section01;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2 ^ 31,2 ^ 31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2 ^ 31 的整数应该被固定为 −2 ^ 31 ，大于 2 ^ 31 − 1 的整数应该被固定为 2 ^ 31 − 1 。
 * 返回整数作为最终结果。
 *
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class Problem08StringToInteger {

    public int myAtoi(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int iterator = 0;

        while (' ' == charArray[iterator]) {
            iterator++;
            if (iterator == charArray.length) {
                return 0;
            }
        }

        if ('+' == charArray[iterator] || '-' == charArray[iterator]) {
            iterator++;
            if (iterator == charArray.length) {
                return 0;
            }
            if (!('0' <= charArray[iterator] && charArray[iterator] <= '9')) {
                return 0;
            }
        }
        else if (!('0' <= charArray[iterator] && charArray[iterator] <= '9')) {
            return 0;
        }

        int iteratorNum = charArray[iterator] - 48;

        boolean negative = false;
        if (iterator == 0) {
            negative = false;
        }
        else if ('-' == charArray[iterator - 1]) {
            negative = true;
        }

        if (negative) {
            iteratorNum = -iteratorNum;
        }
        iterator++;

        int high;
        int low;
        int overFlowAdd;
        int overFlowMultiply;
        if (negative) {
            overFlowAdd = Integer.MIN_VALUE;
            overFlowMultiply = Integer.MIN_VALUE / 10;
            while (iterator < charArray.length && '0' <= charArray[iterator] && charArray[iterator] <= '9') {
                if (iteratorNum < overFlowMultiply) {
                    return Integer.MIN_VALUE;
                }
                high = iteratorNum * 10;
                low = - charArray[iterator] + 48;
                if (overFlowAdd - high > low) {
                    return Integer.MIN_VALUE;
                }
                iteratorNum = high + low;
                iterator++;
            }
        }
        else {
            overFlowAdd = Integer.MAX_VALUE;
            overFlowMultiply = Integer.MAX_VALUE / 10;
            while (iterator < charArray.length && '0' <= charArray[iterator] && charArray[iterator] <= '9') {
                if (iteratorNum > overFlowMultiply) {
                    return Integer.MAX_VALUE;
                }
                high = iteratorNum * 10;
                low = charArray[iterator] - 48;
                if (overFlowAdd - high < low) {
                    return Integer.MAX_VALUE;
                }
                iteratorNum = high + low;
                iterator++;
            }
        }

        return iteratorNum;
    }

    public static void main(String[] args) {
        String a = "0123456789";
        char[] b = new char[a.length()];
        int[] c = new int[a.length()];
        int[] d = new int[a.length()];

        for (int i = 0; i <a.length(); i++) {
            char e = a.charAt(i);
            b[i] = e;
            c[i] = e;
            d[i] = e - 48;
        }

        for (int i = 0; i < a.length(); i++) {
            System.out.print(b[i]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < a.length(); i++) {
            System.out.print(c[i]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < a.length(); i++) {
            System.out.print(d[i]);
            System.out.print("\t");
        }
    }
}
