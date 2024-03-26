package com.nero.normal.section01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Problem17LetterCombinationsOfAPhoneNumber {

    private static List<Character>[] digitMapCharList = new List[8];

    static {
        digitMapCharList[0] = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        digitMapCharList[1] = new ArrayList<>(Arrays.asList('d', 'e', 'f'));
        digitMapCharList[2] = new ArrayList<>(Arrays.asList('g', 'h', 'i'));
        digitMapCharList[3] = new ArrayList<>(Arrays.asList('j', 'k', 'l'));
        digitMapCharList[4] = new ArrayList<>(Arrays.asList('m', 'n', 'o'));
        digitMapCharList[5] = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
        digitMapCharList[6] = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
        digitMapCharList[7] = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinationsOfAPhoneNumber(String digitString) {
        List<String> combinationStringList = new LinkedList<>();
        if (null == digitString || "".equals(digitString)) {
            return combinationStringList;
        }

        final int DIGIT_CHAR_TO_DIGIT = 48;
        final int DIGIT_TO_CHAR_LIST = 2;

        List<Character>[] digitCharList = new List[digitString.length()];
        int[] digitCharListTraversalState = new int[digitString.length()];

        for (int i = 0 ; i < digitString.length(); i++) {
            digitCharList[i] = digitMapCharList[digitString.charAt(i) - DIGIT_CHAR_TO_DIGIT - DIGIT_TO_CHAR_LIST];
        }

        char[] thisTimeCharArray = new char[digitString.length()];
        do {
            for (int i = 0; i < digitString.length(); i++) {
                thisTimeCharArray[i] = digitCharList[i].get(digitCharListTraversalState[i]);
            }
            combinationStringList.add(new String(thisTimeCharArray));
            nextTimeState(digitCharListTraversalState, digitCharList);
        } while (digitCharListTraversalFinish(digitCharListTraversalState, digitCharList));

        return combinationStringList;
    }

    /**
     * 看起来非常有趣 某种形式 + 1
     * 像十进制一样，只不过每个位置得进制是不一样得
     *
     * @param digitCharListTraversalState
     * @param digitCharList
     */
    private void nextTimeState(int[] digitCharListTraversalState, List<Character>[] digitCharList) {
        for (int i = digitCharListTraversalState.length - 1; i >= 0; i--) {
            if (digitCharListTraversalState[i] == digitCharList[i].size() - 1) {
                digitCharListTraversalState[i] = 0;
            }
            else {
                digitCharListTraversalState[i] += 1;
                break;
            }
        }
    }

    private boolean digitCharListTraversalFinish(int[] digitCharListTraversalState, List<Character>[] digitCharList) {
        for (int i = 0; i < digitCharListTraversalState.length; i++) {
            if (digitCharListTraversalState[i] != 0) {
                return true;
            }
        }

        return false;
    }


}
