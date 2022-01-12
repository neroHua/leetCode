package com.nero;

public class Problem05LongestPalindromicSubstring {

    /**
     * O(1 ^ 2 + 2 ^ 2 + 3 ^ 3 + (n - 1) ^ 2 + (n - 2) ^ 2 = n ^ 3)
     * O(n ^ 3)
     *
     * @param s
     * @return
     */
    public String longestPalindrome01(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int startIndex = j;
                int endIndex = s.length() - i - 1 + j;
                boolean isSubStringPalindromic = true;
                for (int k = startIndex; k <= (startIndex + endIndex) / 2; k++) {
                    if (s.charAt(k) != s.charAt(endIndex - (k - startIndex))) {
                        isSubStringPalindromic = false;
                        break;
                    }
                }
                if (isSubStringPalindromic) {
                    return s.substring(startIndex, endIndex + 1);
                }
            }
        }

        return s.substring(0, 1);
    }

}
