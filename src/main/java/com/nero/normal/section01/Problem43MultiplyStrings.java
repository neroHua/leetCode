package com.nero.normal.section01;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class Problem43MultiplyStrings {

    public String multiply(String num1, String num2) {
        int[] number1 = convertStringToIntArray(num1);
        int[] number2 = convertStringToIntArray(num2);

        int[][] middleNumberArray = new int[number2.length][number1.length + number2.length];
        for (int i = num2.length() - 1; i >= 0; i--) {
            multiplyMiddle(number1, number2, i, middleNumberArray);
        }

        int[] sumArray = new int[number1.length + number2.length];
        sumMiddleNumberArray(sumArray, middleNumberArray);

        return convertSumArrayToString(sumArray);
    }

    private int[] convertStringToIntArray(String num1) {
        int[] number = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            number[i] = num1.charAt(i) - 48;
        }

        return number;
    }

    public void multiplyMiddle(int[] number1Array, int[] number2Array, int index, int[][] middleNumberArray) {
        int y = number2Array.length - 1 - index;
        int number = number2Array[index];
        int carry = 0;
        int x = number1Array.length + index;
        for (int i = number1Array.length - 1; i >= 0; i--, x--) {
            int iMiddle = number1Array[i] * number + carry;
            middleNumberArray[y][x] = iMiddle % 10;
            carry = iMiddle / 10;
        }
        middleNumberArray[y][x] = carry;
    }

    private void sumMiddleNumberArray(int[] sumArray, int[][] middleNumberArray) {
        int carry = 0;
        for (int y = sumArray.length - 1; y >= 0; y--) {
            int xSum = 0;
            for (int x = 0; x < middleNumberArray.length; x++) {
                xSum += middleNumberArray[x][y];
            }
            xSum += carry;
            sumArray[y] = xSum % 10;
            carry = xSum / 10;
        }
    }

    private String convertSumArrayToString(int[] sumArray) {
        StringBuilder stringBuilder = new StringBuilder();
        if (sumArray[0] == 0) {
            if (sumArray[1] == 0) {
                return "0";
            }
        }
        else {
            stringBuilder.append(sumArray[0]);
        }

        for (int i = 1; i < sumArray.length; i++) {
            stringBuilder.append(sumArray[i]);
        }

        return stringBuilder.toString();
    }

}
