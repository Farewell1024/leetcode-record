package com.zhangyu.leetcoderecord.unfinished;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 6/7/21
 * @since JDK 1.8
 */
public class Solution0494 {

    public static void main(String[] args) {
        Solution0494 solution = new Solution0494();
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    private int count = 0;

    /**
     * dfs
     */
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, target, 0, 0);
        return count;
    }

    private void helper(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count ++;
            }
            return;
        }
        helper(nums, target, index + 1, sum + nums[index]);
        helper(nums, target, index + 1, sum - nums[index]);
    }


}
