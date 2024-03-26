package com.nero.normal.section01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class Problem22GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(generateParenthesisSet(n));
    }

    public Set<String> generateParenthesisSet(int n) {
        if (n == 1) {
            return new HashSet<String>() {{
                add("()");
            }};
        }

        Set<String> prePair = generateParenthesisSet(n - 1);
        Set<String> currentPair = new HashSet<>();
        for (String preString : prePair) {
            currentPair.add("()" + preString);
            currentPair.add(preString + "()");
            for (int i = 0; i < preString.length(); i++) {
                String iPair = preString.substring(0, i) + "()" + preString.substring(i, preString.length());
                currentPair.add(iPair);
            }
        }

        return currentPair;
    }
}
