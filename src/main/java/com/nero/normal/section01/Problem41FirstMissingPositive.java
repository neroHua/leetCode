package com.nero.normal.section01;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10 ^ 5
 * -2 ^ 31 <= nums[i] <= 2 ^ 31 - 1
 *
 * 滑德友：
 * 这个题目我能想到
 * 1. 快排 + 一轮 但是效率是O(nlog(n))
 * 2. 利用hash 但是需要额外内存O(n)效率是O(n),这种办法不知道能不能重复利用现在数组，感觉不太可能
 * 3. 利用线性排序中的计数排序思想, 把当前数组当做辅助数组，大于和小于当前数组的长度的数值直接丢弃即可。即是一轮插入，一轮结果2n
 */
public class Problem41FirstMissingPositive {
}
