package com.nero.normal.section01;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 提示：
 *
 * -2 ^ 31 <= x <= 2 ^ 31 - 1
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Problem09PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        int[] xArray = new int[10];
        int iterator = 0;

        while (x != 0) {
            xArray[iterator] = x % 10;
            x = x / 10;
            iterator++;
        }
        iterator--;

        for (int i = 0, j = iterator; i <= iterator / 2; i++, j--) {
            if (xArray[i] != xArray[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        String b = Integer.toString(a);
        int c = b.length();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
