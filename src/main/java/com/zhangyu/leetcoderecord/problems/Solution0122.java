package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 122. 买卖股票的最佳时机 II
 *
 * @author zhangyu
 * Date: 2020/10/21 18:13
 * @since JDK 1.8
 */
public class Solution0122 {

    public static void main(String[] args) {
        Solution0122 solution = new Solution0122();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

}
