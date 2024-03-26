package com.nero.normal.section01;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 滑德友：
 * 讨厌：请参考编译原理上的NFA和DFA
 */
public class Problem44WildcardMatching {

    Boolean[][] dynamicProgramming;

    /**
     * 这部分代码能通过很多测试用例，但是因为耗时过长，尚未通过所有测试用例
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        else if (s.length() == 0 && p.length() > 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (p.length() > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*') {
                    int j = i + 1;
                    while (j < p.length() && p.charAt(j) == '*') {
                        j++;
                    }
                    stringBuilder.append('*');
                    if (j < p.length() && p.charAt(j) != '*') {
                        stringBuilder.append(p.charAt(j));
                    }
                    i = j;
                }
                else {
                    stringBuilder.append(p.charAt(i));
                }
            }
            p = stringBuilder.toString();
        }

//        dynamicProgramming = new Boolean[s.length() + 1][p.length()];
//        return isMatchSimplifiedDynamicProgramming(s, 0, p, 0);
        return isMatchSimplifiedFromLowToHigh(s, p);
    }

    /**
     * 对于 * 的情况有太多的重复的计算了, 耗时太长了
     * 比如计算 s = bac , p = **b* 计算树为：
     * bac & **b*      ac & **b*   c & **b*    c & *b*    c & b*
     *                             ac & *b*    c & *b*    c & b*
     *                                         ac & b*
     *                             c & *b*     c & b*
     *
     *                 c & **b*    c & **b*    c & *b*    c & b*
     *
     *                 bac & *b*   ac & *b*    c & *b*    c & b*
     *                                         ac & b*
     *                             bac & b*    ac & *     c & *
     *                             ac & b*
     *                             c & b*
     *
     *                 ac & *b*    c & *b*     c & b*
     *                             ac & b*
     *
     *                 c & *b*     c & b*
     *
     * 对于 ac & *b* 有多次计算
     *
     * 更加深入的分析解析表达式
     * 对于 s = 'bbaabaabbabababbaababbaaabbbaaab' p = '*bba*a*bbba*aab*b'
     *
     * f(s, 0, p, 0) =                  f(s, 1, p, 0) || f(s, 2, p, 0) || ..... f(s, Sn - 1, p, 0) || f(s, Sn, p, 0)
     *              || f(s, 0, p, 1) || f(s, 1, p, 1) || f(s, 2, p, 1) || ..... f(s, Sn - 1, p, 1) || f(s, Sn, p, 1)
     *
     * f(s, 1, p, 0) =                  f(s, 2, p, 0) || f(s, 3, p, 0) || ..... f(s, Sn - 1, p, 0) || f(s, Sn, p, 0)
     *              || f(s, 1, p, 1) || f(s, 2, p, 1) || f(s, 3, p, 1) || ..... f(s, Sn - 1, p, 1) || f(s, Sn, p, 1)
     *
     * 由此我们可以发现 f(s, 0, p, 0) = f(s, 1, p, 0) || f(s, 0, p, 1)
     *
     *
     * @param s
     * @param sIndex
     * @param p
     * @param pIndex
     * @return
     */
    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex < p.length() && p.charAt(pIndex) == '*') {
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        else if (sIndex >= s.length() || pIndex >= p.length()) {
            return false;
        }

        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                return true;
            }
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                return true;
            }

            for (int i = sIndex; i < s.length() - 1; i++) {
                if (isMatch(s, i + 1, p, pIndex)) {
                    return true;
                }
            }

            for (int i = sIndex; i <= s.length(); i++) {
                if (isMatch(s, i, p, pIndex + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * s =
     * "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
     * p =
     * "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
     * 超时了，可以考虑 把 多个 * 保留 一个 *
     *
     * 再次优化后可以通过 95% 的用例
     * 但是对于下面的用例还是超时了
     * s =
     * "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
     * p =
     * "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
     * p' =
     * "*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a**ba*bbb*a*ba*bb*bb**a*b*bb"
     *
     * 以上面的情况来分析有点难受
     * 用这样的例子来分析
     * s1 = "aaaaaaaaaaaaa" p1 = "*************"
     * f(s, 0, p, 0)
     * 	    f(s, 1, p, 0)
     * 		    f(s, 2, p, 0)
     * 			    f(s, 3 p, 0)
     * 			    f(s, 2, p, 1)
     * 		    f(s, 1, p, 1)
     * 			    f(s, 2, p, 1)
     * 			    f(s, 1, p, 2)
     * 	    f(s, 0, p, 1)
     * 		    f(s, 2, p, 1)
     * 		    f(s, 0, p, 2)
     * 可以明显看到对于f(s, 2, p, 1)进行了多次计算
     *
     * 那么优化后只有一个*的情况
     * s2 = "aaaaaaaaaaaaa" p2 = "*a*a*a*a*a*a*"
     * f(s, 0, p, 0)
     *     f(s, 1, p, 0)
     *         f(s, 2, p, 0)
     *             f(s, 3 p, 0)
     *             f(s, 2, p, 1)
     *         f(s, 1, p, 1)
     *             f(s, 2, p, 2)
     *                 f(s, 3, p, 2)
     *                 f(s, 2, p, 3)
     *     f(s, 0, p, 1)
     *         f(s, 2, p, 3)
     *             f(s, 3, p, 3)
     *             f(s, 2, p, 4)
     * 可以看到对于f(s, 2, p, 3)进行了多次计算
     *
     * 对于此可以考虑动态规划，把计算的结果存储起来下次拿到直接使用，因为有两个变量所以应该是二位数组。
     * 还有一种办法不再使用递归，使用循环来计算，先计算最低项再计算高项，顺序计算完成。
     * 因为是二维的，循环计算需要计算所有的底项，才能向高项计算(因为*),递归仅计算需要路径，感觉递归更快一点。
     *
     * @param s
     * @param sIndex
     * @param p
     * @param pIndex
     * @return
     */
    private boolean isMatchSimplified(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex < p.length() && p.charAt(pIndex) == '*') {
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        else if (sIndex >= s.length() || pIndex >= p.length()) {
            return false;
        }

        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                return true;
            }
            return isMatchSimplified(s, sIndex + 1, p, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                return true;
            }

            if (isMatchSimplified(s, sIndex + 1, p, pIndex)) {
                return true;
            }

            if (isMatchSimplified(s, sIndex, p, pIndex + 1)) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    private boolean isMatchSimplifiedDynamicProgramming(String s, int sIndex, String p, int pIndex) {
        if (sIndex < s.length() && pIndex < p.length() && null != dynamicProgramming[sIndex][pIndex]) {
            return dynamicProgramming[sIndex][pIndex];
        }

        if (sIndex == s.length() && pIndex < p.length() && p.charAt(pIndex) == '*') {
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    dynamicProgramming[sIndex][pIndex] = false;
                    return false;
                }
            }
            dynamicProgramming[sIndex][pIndex] = true;
            return true;
        }
        else if (sIndex >= s.length() || pIndex >= p.length()) {
            return false;
        }

        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                dynamicProgramming[sIndex][pIndex] = true;
                return true;
            }
            return isMatchSimplifiedDynamicProgramming(s, sIndex + 1, p, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            if (sIndex == s.length() - 1 && pIndex == p.length() - 1) {
                dynamicProgramming[sIndex][pIndex] = true;
                return true;
            }

            if (isMatchSimplifiedDynamicProgramming(s, sIndex + 1, p, pIndex)) {
                dynamicProgramming[sIndex][pIndex] = true;
                return true;
            }

            if (isMatchSimplifiedDynamicProgramming(s, sIndex, p, pIndex + 1)) {
                dynamicProgramming[sIndex][pIndex] = true;
                return true;
            }
            dynamicProgramming[sIndex][pIndex] = false;
            return false;
        } else {
            dynamicProgramming[sIndex][pIndex] = false;
            return false;
        }
    }

    private boolean isMatchSimplifiedFromLowToHigh(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        else if (s.length() != 0 && p.length() == 0) {
            return false;
        }

        boolean[][] fromLowToHigh = new boolean[s.length() + 1][p.length() + 1];
        for (int i = p.length() - 1; i >= 0 && p.charAt(i) == '*'; i--) {
            fromLowToHigh[s.length()][p.length() - 1] = true;
        }
        if (s.charAt(s.length() - 1) == p.charAt(p.length() - 1) || p.charAt(p.length() - 1) == '?') {
            fromLowToHigh[s.length()][p.length()] = true;
        }

        for (int sIndex = s.length() - 1; sIndex >= 0; sIndex--) {
            for (int pIndex = p.length() - 1; pIndex >= 0; pIndex--) {
                if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
                    fromLowToHigh[sIndex][pIndex] = fromLowToHigh[sIndex + 1][pIndex + 1];
                }
                else if (p.charAt(pIndex) == '*'){
                    fromLowToHigh[sIndex][pIndex] = fromLowToHigh[sIndex + 1][pIndex] || fromLowToHigh[sIndex][pIndex + 1];
                }
            }
        }

        return fromLowToHigh[0][0];
    }

}
