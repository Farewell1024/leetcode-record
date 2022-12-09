package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 88. 合并两个有序数组
 *
 * @author zhangyu
 * Date: 6/12/21
 * @since JDK 1.8
 */
public class Solution0088 {

    public static void main(String[] args) {
        Solution0088 solution = new Solution0088();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        solution.merge(new int[]{1}, 1, new int[0], 0);
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i : nums2) {
            nums1[m ++] = i;
        }
        Arrays.sort(nums1);
    }

}
