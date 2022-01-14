package com.nero;

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
