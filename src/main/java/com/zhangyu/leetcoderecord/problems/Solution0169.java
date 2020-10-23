package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 169. 多数元素
 *
 * @author zhangyu
 * Date: 2020/10/23 11:50
 * @since JDK 1.8
 */
public class Solution0169 {

    public static void main(String[] args) {
        Solution0169 solution = new Solution0169();
        System.out.println(solution.majorityElement(new int[]{3,2,3}));
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
