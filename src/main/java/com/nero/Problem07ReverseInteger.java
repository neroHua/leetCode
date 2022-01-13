package com.nero;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2 ^ 31, 2 ^ 31 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 提示：
 * -2 ^ 31 <= x <= 2 ^ 31 - 1
 *
 */
public class Problem07ReverseInteger {

    public int reverse01(int x) {
        String s = Integer.toString(x);

        StringBuilder stringBuilder = new StringBuilder(s);
        String s1 = stringBuilder.reverse().toString();

        if ('-' == s1.charAt(s1.length() - 1)) {
            s1 = "-" + s1.substring(0, s1.length() - 1);
        }

        int reverse = 0;

        try {
            reverse = Integer.parseInt(s1);
        } catch (NumberFormatException e) {
            reverse = 0;
        }

        return reverse;
    }

}
