package com.nero.normal.section01;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 */
public class Problem06ZigZagConversion {

    /**
     * O(n)
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }

        char[] charArray = new char[s.length()];
        if (numRows == 2) {
            for (int i = 0; i < s.length(); i += 2) {
                charArray[i / 2] = s.charAt(i);
            }
            int startIndex = (s.length() - 1) / 2 + 1;
            for (int i = 1, j = 0; i < s.length(); i += 2, j++) {
                charArray[startIndex + j] = s.charAt(i);
            }
            return new String(charArray);
        }

        int halfEachLength = numRows - 1;
        int eachLength = 2 * halfEachLength;
        int eachLoopTimes = s.length() / eachLength + 1;
        int twiceEachLoopTimes = 2 * eachLoopTimes;
        int charArrayCourse = 0;

        for (int i = 0; i < eachLoopTimes; i++, charArrayCourse++) {
            int charIndex = i * eachLength;
            if (charIndex >= s.length()) {
                break;
            }
            charArray[charArrayCourse] = s.charAt(charIndex);
        }
        for (int j = 1; j < numRows - 1; j++) {
            for (int i = 0; i < twiceEachLoopTimes; i++, charArrayCourse++) {
                int halfIndex = i / 2;
                int charIndex = i % 2 == 0
                        ? halfIndex * eachLength + j
                        : (halfIndex + 1) * eachLength - j;
                if (charIndex >= s.length()) {
                    break;
                }
                charArray[charArrayCourse] = s.charAt(charIndex);
            }
        }

        for (int i = 0; i < eachLoopTimes; i++, charArrayCourse++) {
            int charIndex = i * eachLength + halfEachLength;
            if (charIndex >= s.length()) {
                break;
            }
            charArray[charArrayCourse] = s.charAt(charIndex);
        }

        return new String(charArray);
    }

}
