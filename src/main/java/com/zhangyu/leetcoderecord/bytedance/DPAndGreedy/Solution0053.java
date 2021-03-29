package com.zhangyu.leetcoderecord.bytedance.DPAndGreedy;

/**
 * Function: 53. 最大子序和
 *
 * @author zhangyu
 * Date: 2021/3/25
 * @since JDK 1.8
 */
public class Solution0053 {

    public static void main(String[] args) {
        Solution0053 solution = new Solution0053();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{0}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-10000}));
    }

    /**
     * 动态规划
     *
     * 从左至右以此求出每一个点的最大和
     * 每个点的最大和 等于 前一个点的最大和加上自己 和 自己相比的较大值
     *                  连续                     不连续
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(pre, result);
        }
        return result;
    }
}
