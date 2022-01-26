package com.nero.normal.section01;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 */
public class Problem32LongestValidParentheses {

    char[] sArray;
    int[][] currentMaxLongestValidArray;

    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }

        sArray = s.toCharArray();
        return subLongestValidParentheses( 0, s.length() - 1);
    }

    private int subLongestValidParentheses(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (currentIsValidParentheses(start, end)) {
            return end - start + 1;
        }

        int sub1 = subLongestValidParentheses(start + 1, end);
        int sub2 = subLongestValidParentheses(start, end - 1);

        return sub1 > sub2 ? sub1 : sub2;
    }

    private boolean currentIsValidParentheses(int start, int end) {
        if ((end - start + 1) % 2 != 0) {
            return false;
        }
        if (')' == sArray[start]) {
            return false;
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            if ('(' == sArray[i]) {
                count++;
            }
            else {
                count--;
            }
            if (count == 0 && i < end) {
                if(currentIsValidParentheses(i + 1, end)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        return count == 0 ? true : false;
    }

    public int longestValidParentheses02(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }

        sArray = s.toCharArray();
        currentMaxLongestValidArray = new int[s.length()][s.length()];
        return subLongestValidParentheses02( 0, s.length() - 1);
    }

    private int subLongestValidParentheses02(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (currentMaxLongestValidArray[start][end] != 0) {
            return currentMaxLongestValidArray[start][end];
        }

        int sub1 = 0;
        if (currentMaxLongestValidArray[start + 1][end] == 0) {
            sub1 = subLongestValidParentheses02(start + 1, end);
            currentMaxLongestValidArray[start + 1][end] = sub1;
        }
        else {
            sub1 = currentMaxLongestValidArray[start + 1][end];
        }

        int sub2 = 0;
        if (currentMaxLongestValidArray[start][end - 1] == 0) {
            sub2 = subLongestValidParentheses02(start, end - 1);
            currentMaxLongestValidArray[start][end - 1] = sub2;
        }
        else {
            sub2 = currentMaxLongestValidArray[start][end - 1];
        }

        int max = 0;
        max = sub1 > sub2 ? sub1 : sub2;
        if (currentIsValidParentheses02(start, end) == end - start + 1) {
            max = end - start + 1;
        }

        currentMaxLongestValidArray[start][end] = max;
        return max;
    }

    private int currentIsValidParentheses02(int start, int end) {
        if (currentMaxLongestValidArray[start][end] != 0) {
            return currentMaxLongestValidArray[start][end];
        }

        if (')' == sArray[start]) {
            return 0;
        }
        if ((end - start + 1) % 2 != 0) {
            return 0;
        }
        int count = 0;
        int i = start;
        while (i <= end) {
            if ('(' == sArray[i]) {
                count++;
            }
            else {
                count--;
            }

            if (count == 0) {
                currentMaxLongestValidArray[start][i] = i - start + 1;
                if (i == end) {
                    return end - start + 1;
                }
                else if (i < end) {
                    if (currentIsValidParentheses02(i + 1, end) == end - i) {
                        currentMaxLongestValidArray[i + 1][end] = end - i;
                        currentMaxLongestValidArray[start][end] = end - start + 1;
                        return end - start + 1;
                    }
                    break;
                }
            }

            i++;
        }

        return 0;
    }

    public int longestValidParentheses03(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }

        sArray = s.toCharArray();
        int value = 0;
        int maxLength = 0;
        int currentStart = -1;

        int previousMaxValidLength = 0;
        int previousMaxValidStartIndex = -1;
        int previousMaxValidEndIndex = -1;

        int currentMaxValidLength = 0;
        int currentMaxValidStartIndex = 0;
        int currentMaxValidEndIndex = 0;

        int previousZeroMaxValidLength = 0;
        int previousZeroMaxValidStartIndex = -1;
        int previousZeroMaxValidEndIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if ('(' == sArray[i]) {
                currentMaxValidStartIndex = i + 1;
                currentMaxValidEndIndex = i + 1;
                currentMaxValidLength = 0;

                value++;
            }
            else {
                if (value >= 1) {
                    currentMaxValidLength += 2;
                    currentMaxValidEndIndex = i;
                    currentMaxValidStartIndex = currentMaxValidEndIndex - currentMaxValidLength + 1;

                    if (currentMaxValidStartIndex == previousMaxValidEndIndex + 1) {
                        previousMaxValidEndIndex = currentMaxValidEndIndex;
                        previousMaxValidLength += currentMaxValidLength;

                        currentMaxValidLength = 0;
                        currentMaxValidStartIndex = i + 1;
                        currentMaxValidEndIndex = i + 1;
                        maxLength = maxLength > previousMaxValidLength ? maxLength : previousMaxValidLength;
                    }
                    else if (currentMaxValidEndIndex - 1 == previousMaxValidEndIndex) {
                        previousMaxValidEndIndex = currentMaxValidEndIndex;
                        previousMaxValidLength += currentMaxValidLength;
                        previousMaxValidStartIndex = previousMaxValidEndIndex - previousMaxValidLength + 1;

                        if (previousZeroMaxValidEndIndex + 1 == previousMaxValidStartIndex) {
                            previousMaxValidStartIndex = previousZeroMaxValidStartIndex;
                            previousMaxValidLength += previousZeroMaxValidLength;
                        }
                        else if (previousZeroMaxValidLength == 0) {
                            previousZeroMaxValidStartIndex = previousMaxValidStartIndex;
                            previousZeroMaxValidEndIndex = previousMaxValidEndIndex;
                            previousZeroMaxValidLength = previousMaxValidLength;
                        }

                        currentMaxValidLength = 0;
                        currentMaxValidStartIndex = i + 1;
                        currentMaxValidEndIndex = i + 1;
                        maxLength = maxLength > previousMaxValidLength ? maxLength : previousMaxValidLength;
                    }
                    else {
                        previousMaxValidStartIndex = currentMaxValidStartIndex;
                        previousMaxValidEndIndex = currentMaxValidEndIndex;
                        previousMaxValidLength = currentMaxValidLength;

                        currentMaxValidLength = 0;
                        currentMaxValidStartIndex = i + 1;
                        currentMaxValidEndIndex = i + 1;
                        maxLength = maxLength > previousMaxValidLength ? maxLength : previousMaxValidLength;
                    }
                }
                else {
                    currentMaxValidStartIndex = i + 1;
                    currentMaxValidEndIndex = i + 1;
                    currentMaxValidLength = 0;
                }
                value = value == 0 ? 0 : value - 1;
            }
        }

        return maxLength;
    }

}
