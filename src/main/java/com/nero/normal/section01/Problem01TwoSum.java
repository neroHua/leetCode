package com.nero.normal.section01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 */
public class Problem01TwoSum {

    /**
     * O(n ^ 2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int rest = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == rest) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> helpMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pairedIndex = helpMap.get(nums[i]);
            if (null != pairedIndex) {
                return new int[]{i, pairedIndex};
            }
            else {
                helpMap.put(target - nums[i], i);
            }
        }

        return null;
    }

}
