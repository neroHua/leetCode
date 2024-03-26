package com.nero.normal.section01;

import java.util.LinkedList;
import java.util.List;

public class Problem20ValidParentheses {

    /**
     * 通过前两天在基础得想法上进一步深挖和改进
     * 可知
     * 对于正确的括号组合，每次移除 s[i] 和 s[i + 1]，依然是正确得括号组合
     *  s[i] = '(' && s[i + 1] = ')'
     *  s[i] = '[' && s[i + 1] = ']'
     *  s[i] = '{' && s[i + 1] = '}'
     *
     *  所以在一次遍历的过程每次删除就好了
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        List<Character> sList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }

        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i) == ')') {
                if (i - 1 < 0) {
                    return false;
                }
                else if (sList.get(i - 1) == '(') {
                    sList.remove(i);
                    sList.remove(i - 1);
                    i -= 2;
                }
                else if (sList.get(i - 1) == '[' || sList.get(i - 1) == '{') {
                    return false;
                }
            }
            else if (sList.get(i) == ']') {
                if (i - 1 < 0) {
                    return false;
                }
                else if (sList.get(i - 1) == '[') {
                    sList.remove(i);
                    sList.remove(i - 1);
                    i -= 2;
                }
                else if (sList.get(i - 1) == '(' || sList.get(i - 1) == '{') {
                    return false;
                }
            }
            else if (sList.get(i) == '}') {
                if (i - 1 < 0) {
                    return false;
                }
                else if (sList.get(i - 1) == '{') {
                    sList.remove(i);
                    sList.remove(i - 1);
                    i -= 2;
                }
                else if (sList.get(i - 1) == '(' || sList.get(i - 1) == ')') {
                    return false;
                }
            }
        }

        return sList.size() == 0 ? true : false;
    }


}
