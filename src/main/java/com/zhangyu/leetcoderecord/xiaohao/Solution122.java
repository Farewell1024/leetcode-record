package com.zhangyu.leetcoderecord.xiaohao;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2/23/22
 * @since JDK 1.8
 */
public class Solution122 {

    public static void main(String[] args) {
        Solution122 solution = new Solution122();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i-1]);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // not hold
        dp[0][0] = 0;
        // hold
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
