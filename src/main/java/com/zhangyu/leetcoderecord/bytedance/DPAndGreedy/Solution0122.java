package com.zhangyu.leetcoderecord.bytedance.DPAndGreedy;

/**
 * Function: 122. 买卖股票的最佳时机 II
 *
 * @author zhangyu
 * Date: 2021/3/24 09:52
 * @since JDK 1.8
 */
public class Solution0122 {

    public static void main(String[] args) {
        Solution0122 solution = new Solution0122();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * 一次遍历
     * 就是找到股票折线图中所有上升趋势的线，求之利润之和
     * 又有 在一段上升趋势中，第一天买入第三天卖出，等于第一天买入第二天卖出 再第二天买入第三天卖出
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    /**
     * 动态规划
     *
     * 每次手里只能持有一只股票，所以在当日交易结束后，手中会有持有和不持有两种状态
     * 当天持有的收益 = max(前一天的持有收益，前一天的不持有收益 - 今日价格)     后一部分为今日买入
     * 当天不持有收益 = max(前一天不持有收益，前一天的持有收益 + 今日价格)       后一部分为今日卖出
     */
    public int maxProfit3(int[] prices) {
        int[][] carry = new int[prices.length][2];
        carry[0][0] = -prices[0];
        carry[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            carry[i][0] = Math.max(carry[i - 1][0], carry[i - 1][1] - prices[i]);
            carry[i][1] = Math.max(carry[i - 1][1], carry[i - 1][0] + prices[i]);
        }
        return carry[prices.length-1][1];
    }

    /**
     * 优化后的动态规划
     */
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int drop = 0;
        for (int i = 1; i < prices.length; i++) {
            int h2 = hold;
            hold = Math.max(hold, drop - prices[i]);
            drop = Math.max(drop, h2 + prices[i]);
        }
        return drop;
    }

}
