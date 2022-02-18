package com.nero.normal.section01;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 滑德友：
 * world1	world2	minOperationCount
 * 		            0
 * 	        a	    1
 * 	        ab	    2
 * 	        abc	    3
 * b	    a	    1
 * b	    ab	    1
 * b	    abc	    2
 * b	    ac	    2
 * b	    acd	    3
 *
 * bd	    a	    2
 * bd	    ab	    2
 * bd	    abc	    2
 * bd	    abcd	2
 * bd	    abcde	3
 * bd	    edcba	4
 *
 * bde	    a	    3
 * bde	    ab	    3
 * bde	    abc	    3
 * bde	    abcd	3
 * bde	    abcde	2
 * bde	    edcba	4	取b得5	取d得4	取e得7	放弃e得5
 *
 * 对上图进行分析可以简单得到：
 * 1. minOperationCount <= max(world1.length, world2.length)
 * 2. 当world1和world2没有相似的字符时, minOperationCount = max(world1.length, world2.length)
 * 3. 当world1和world2相等时，minOperationCount = 0
 * 4. 当world1是world2的子字符串时， minOperationCount = world2.length - world1.length
 *
 * 对bd和bde进一步分析可以得出：minOperationCount跟 world1,world2的最长的不连续的子序列情况有直接关系
 * 也就是要找最长的不连续的公共子序列，寻找的一般解法为(mn)^2
 *
 * 下面给出的是一段穷举所有可能的修改情况的一般解法，效率很容易看出来是word1的长度指数级。
 */
public class Problem72EditDistance {
    private char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public int minDistance(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;

        int removeCount = removeOne(word1, word2, 0);
        minDistance = minDistance < removeCount ? minDistance : removeCount;

        int addCount = addOne(word1, word2, 0);
        minDistance = minDistance < addCount ? minDistance : addCount;

        int changeCount = changeOne(word1, word2, 0);
        minDistance = minDistance < changeCount ? minDistance : changeCount;

        return minDistance;
    }

    private int minDistance(String word1, String word2, int count) {
        if (word1.equals(word2)) {
            return count;
        }
        int minDistance = Integer.MAX_VALUE;

        int removeCount = removeOne(word1, word2, count);
        minDistance = minDistance < removeCount ? minDistance : removeCount;

        int addCount = addOne(word1, word2, count);
        minDistance = minDistance < addCount ? minDistance : addCount;

        int changeCount = changeOne(word1, word2, count);
        minDistance = minDistance < changeCount ? minDistance : changeCount;

        return minDistance;
    }

    private int removeOne(String word1, String word2, int count) {
        if (word1.equals(word2)) {
            return count;
        }
        if (word1.length() <= word2.length()) {
            return Integer.MAX_VALUE;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < word1.length(); i++) {
            String removedWord1 = word1.substring(0, i) + word1.substring(i, word1.length());
            int removedMinDistance = minDistance(removedWord1, word2, count + 1);
            minDistance = minDistance < removedMinDistance ? minDistance : removedMinDistance;
        }
        return minDistance;
    }


    private int changeOne(String word1, String word2, int count) {
        if (word1.equals(word2)) {
            return count;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < charArray.length; j++) {
                String replaceWord1 = word1.substring(0, i) + charArray[j] + word1.substring(i, word1.length());
                int addedMinDistance = minDistance(replaceWord1, word2, count + 1);
                minDistance = minDistance < addedMinDistance ? minDistance : addedMinDistance;
            }
        }
        return minDistance;
    }

    private int addOne(String word1, String word2, int count) {
        if (word1.equals(word2)) {
            return count;
        }
        if (word1.length() >= word2.length()) {
            return Integer.MAX_VALUE;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < charArray.length; j++) {
                String addedWord1 = word1.substring(0, i) + charArray[j] + word1.substring(i, word1.length());
                int addedMinDistance = minDistance(addedWord1, word2, count + 1);
                minDistance = minDistance < addedMinDistance ? minDistance : addedMinDistance;
            }
        }
        return minDistance;
    }
}
