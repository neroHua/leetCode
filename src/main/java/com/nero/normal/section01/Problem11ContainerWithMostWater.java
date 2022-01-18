package com.nero.normal.section01;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class Problem11ContainerWithMostWater {

    /**
     * 下面这种算法非常直观, 但是超出了leetCode的时间限制,需要换种思路
     *
     * O(n ^ 2)
     * @param height
     * @return
     */
    public int maxArea01(int[] height) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
                maxArea = maxArea > area ? maxArea : area;
            }
        }

        return maxArea;
    }

    /**
     *  0,1,2,3,4,5,6,7,8
     * [1,8,6,2,5,4,8,3,7]
     *
     * 0 [1][0] max(0) = 1 * max((8 - 0))           = 8
     * 1 [2][3] max(1) = 2 * max((7 - 3), (3 - 1)   = 8
     * 2 [3][7] max(2) = 3 * max((8 - 7) || (7 - 1))= 18
     * 3 [4][5] max(3) = 4 * max((8 - 5) || (5 - 1))= 16
     * 4 [5][4] max(4) = 5 * max((8 - 4) || (4 - 1))= 20
     * 5 [6][2] max(5) = 6 * max((8 - 2) || (2 - 1))= 36
     * 6 [7][8] max(6) = 7 * max((8 - 1))           = 49
     * 7 [8][1] max(7) = 8 * max((6 - 1))           = 40
     * 8 [8][6] max(8) = 8 * max((6 - 1))           = 40
     *
     * @param height
     * @return
     */
    public int maxArea02(int[] height) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            int maxIndex = findHigherMaxIndex(height, i);
            int minIndex = findHigherMinIndex(height, i);
            int max = maxIndex - i;
            int min = i - minIndex;
            area = height[i] * (max > min ? max : min);
            maxArea = maxArea > area ? maxArea : area;
        }

        return maxArea;
    }

    private int findHigherMaxIndex(int[] height, int i) {
        for (int j = height.length - 1; j > i; j--) {
            if (height[j] > height[i]) {
                return j;
            }
        }

        return i;
    }

    private int findHigherMinIndex(int[] height, int i) {
        for (int j = 0; j < i; j++) {
            if (height[j] > height[i]) {
                return j;
            }
        }

        return i;
    }

}
