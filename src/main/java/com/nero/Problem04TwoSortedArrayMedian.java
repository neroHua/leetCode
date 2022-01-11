package com.nero;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 */
public class Problem04TwoSortedArrayMedian {

    /**
     * O(n + m)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length == 0) {
            return findMedianSortedArray(nums2);
        }
        if (null == nums2 || nums2.length == 0) {
            return findMedianSortedArray(nums1);
        }

        int[] helpNums = new int[nums1.length + nums2.length];

        int iterator1 = 0;
        int iterator2 = 0;
        int helpIterator = 0;

        for (; helpIterator < helpNums.length; helpIterator++) {
            if (iterator1 < nums1.length && iterator2 < nums2.length) {
                if (nums1[iterator1] <= nums2[iterator2]) {
                    helpNums[helpIterator] = nums1[iterator1];
                    iterator1++;
                }
                else {
                    helpNums[helpIterator] = nums2[iterator2];
                    iterator2++;
                }
            }
            else if (iterator1 < nums1.length && iterator2 >= nums2.length) {
                helpNums[helpIterator] = nums1[iterator1];
                iterator1++;
            }
            else if (iterator1 >= nums1.length && iterator2 < nums2.length) {
                helpNums[helpIterator] = nums2[iterator2];
                iterator2++;
            }
        }

        return findMedianSortedArray(helpNums);
    }

    public double findMedianSortedArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0.0;
        }

        boolean evenLength = nums.length % 2 == 0;
        int middleIndex = nums.length / 2;

        if (evenLength) {
            return (nums[middleIndex - 1] + nums[middleIndex]) / 2.0;
        }

        return nums[middleIndex];
    }

}
