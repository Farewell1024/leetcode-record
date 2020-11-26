package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 164. 最大间距
 *
 * @author zhangyu
 * Date: 2020/11/26 09:38
 * @since JDK 1.8
 */
public class Solution0164 {

    public static void main(String[] args) {
        Solution0164 solution = new Solution0164();
        System.out.println(solution.maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(solution.maximumGap(new int[]{10}));
    }

    /**
     * Arrays.sort 年轻人不讲武德
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, nums[i+1] - nums[i]);
        }
        return result;
    }
}
