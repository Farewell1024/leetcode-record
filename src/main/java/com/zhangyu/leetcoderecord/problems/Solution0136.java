package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 136. Single Number
 *
 * @author zhangyu
 * Date: 7/14/21
 * @since JDK 1.8
 */
public class Solution0136 {

    public static void main(String[] args) {
        Solution0136 solution = new Solution0136();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(solution.singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
