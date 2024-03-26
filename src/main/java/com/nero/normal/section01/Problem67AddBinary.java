package com.nero.normal.section01;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Problem67AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sumStringBuilder = new StringBuilder();

        int max = a.length() > b.length() ? a.length() : b.length();
        int i = max - 1;
        int carry = 0;
        int ai = a.length() - 1;
        int bi = b.length() - 1;

        while (i >= 0) {
            int aiNumber = ai < 0 ? 0 : a.charAt(ai) == '0' ? 0 : 1;
            int biNumber = bi < 0 ? 0 : b.charAt(bi) == '0' ? 0 : 1;

            int sumi = aiNumber + biNumber + carry;
            carry = sumi < 2 ? 0 : 1;
            sumi = sumi % 2;
            i--;
            ai--;
            bi--;

            sumStringBuilder.append(sumi == 0 ? '0' : '1');
        }

        if (carry == 1) {
            sumStringBuilder.append('1');
        }

        return sumStringBuilder.reverse().toString();
    }
}
