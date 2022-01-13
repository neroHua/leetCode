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

    /**
     * O(n)
     * @param x
     * @return
     */
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

    /**
     * O(n)
     * @param x
     * @return
     */
    public int reverse02(int x) {
        if (x == 0) {
            return 0;
        }

        int reverse = x % 10;
        x = x / 10;
        int reverseHi = 0;
        int reverseLow = 0;

        boolean negative = x < 0;
        int overFlowAdd;
        int overFlowMultiply;


        if (negative) {
            overFlowAdd = Integer.MIN_VALUE;
            overFlowMultiply = overFlowAdd / 10;
            while (x != 0) {
                if (reverseHi < overFlowMultiply) {
                    return 0;
                }
                reverseHi = reverse * 10;
                reverseLow = x % 10;
                if (overFlowAdd - reverseHi > reverseLow) {
                    return 0;
                }
                reverse = reverseHi + reverseLow;
                x = x / 10;
            }
        }
        else {
            overFlowAdd = Integer.MAX_VALUE;
            overFlowMultiply = overFlowAdd / 10;
            while (x != 0) {
                if (reverseHi > overFlowMultiply) {
                    return 0;
                }
                reverseHi = reverse * 10;
                reverseLow = x % 10;
                if (overFlowAdd - reverseHi < reverseLow) {
                    return 0;
                }
                reverse = reverseHi + reverseLow;
                x = x / 10;
            }
        }

        return reverse;
    }

    public static void main(String[] args) {
        int a = -5432;
//        a = - a;
        int a1 = a % 10;
        int a2 = a / 10 % 10;
        int a3 = a / 10 / 10 % 10;
        int a4 = a / 10 / 10 / 10 % 10;

        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
    }

}
