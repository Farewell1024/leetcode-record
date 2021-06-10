package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 518. 零钱兑换 II
 *
 * @author zhangyu
 * Date: 6/10/21
 * @since JDK 1.8
 */
public class Solution0518 {

    public static void main(String[] args) {
        Solution0518 solution = new Solution0518();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{10}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
