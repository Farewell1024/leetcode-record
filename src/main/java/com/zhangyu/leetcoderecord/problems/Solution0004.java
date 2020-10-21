package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 4. 寻找两个正序数组的中位数
 *
 * @author zhangyu
 * Date: 2020/10/21 14:11
 * @since JDK 1.8
 */
public class Solution0004 {

    public static void main(String[] args) {
        Solution0004 solution = new Solution0004();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    /**
     * 合二为一，取中间下标
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = null;
        if (nums1 == null) {
            result = nums2;
        } else if (nums2 == null) {
            result = nums1;
        } else {
            result = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    result[i + j] = nums1[i++];
                } else {
                    result[i + j] = nums2[j++];
                }
            }
            while (i < nums1.length) {
                result[i + j] = nums1[i++];
            }
            while (j < nums2.length) {
                result[i + j] = nums2[j++];
            }
        }
        return result.length % 2 == 1 ? result[result.length / 2] :
                (result[result.length / 2] + result[result.length / 2 - 1]) / 2.0;
    }

}
