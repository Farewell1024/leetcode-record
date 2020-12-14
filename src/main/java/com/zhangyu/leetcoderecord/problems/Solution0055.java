package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 55. 跳跃游戏
 *
 * @author zhangyu
 * Date: 2020/12/14 10:59
 * @since JDK 1.8
 */
public class Solution0055 {

    public static void main(String[] args) {
        Solution0055 solution = new Solution0055();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 贪心算法
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }
}
