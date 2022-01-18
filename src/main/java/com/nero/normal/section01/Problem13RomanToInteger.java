package com.nero.normal.section01;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做 XXVII, 即为XX + V + II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V(5) 和 X(10) 的左边，来表示 4 和 9。
 * X 可以放在 L(50) 和 C(100) 的左边，来表示 40 和 90。
 * C 可以放在 D(500) 和 M(1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 *
 */
public class Problem13RomanToInteger {

    public int romanToInt(String s) {
        char[] sArray = s.toCharArray();
        int num = 0;
        for (int i = 0; i < sArray.length; i++) {
            if ('M' == sArray[i]) {
                num += 1000;
            }
            else if ('D' == sArray[i]) {
                num += 500;
            }
            else if ('C' == sArray[i]) {
                if (i + 1 < sArray.length) {
                    if ('M' == sArray[i + 1]) {
                        num += 900;
                        i++;
                    }
                    else if ('D' == sArray[i + 1]) {
                        num += 400;
                        i++;
                    }
                    else {
                        num += 100;
                    }
                }
                else {
                    num += 100;
                }
            }
            else if ('L' == sArray[i]) {
                num += 50;
            }
            else if ('X' == sArray[i]) {
                if (i + 1 < sArray.length) {
                    if ('C' == sArray[i + 1]) {
                        num += 90;
                        i++;
                    } else if ('L' == sArray[i + 1]) {
                        num += 40;
                        i++;
                    } else {
                        num += 10;
                    }
                } else {
                    num += 10;
                }
            }
            else if ('L' == sArray[i]) {
                num += 50;
            }
            else if ('X' == sArray[i]) {
                if (i + 1 < sArray.length) {
                    if ('C' == sArray[i + 1]) {
                        num += 90;
                        i++;
                    }
                    else if ('L' == sArray[i + 1]) {
                        num += 40;
                        i++;
                    }
                    else {
                        num += 10;
                    }
                }
                else {
                    num += 10;
                }
            }
            else if ('V' == sArray[i]) {
                num += 5;
            }
            else if ('I' == sArray[i]) {
                if (i + 1 < sArray.length) {
                    if ('X' == sArray[i + 1]) {
                        num += 9;
                        i++;
                    }
                    else if ('V' == sArray[i + 1]) {
                        num += 4;
                        i++;
                    }
                    else {
                        num += 1;
                    }
                }
                else {
                    num += 1;
                }
            }
        }

        return num;
    }

}
