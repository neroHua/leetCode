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

}
