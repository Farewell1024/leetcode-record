package com.zhangyu.leetcoderecord.bytedance.DPAndGreedy;

/**
 * Function: 121. 买卖股票的最佳时机
 *
 * @author zhangyu
 * Date: 2021/3/24 09:43
 * @since JDK 1.8
 */
public class Solution0121 {

    public static void main(String[] args) {
        Solution0121 solution = new Solution0121();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                result = Math.max(result, price - min);
            }
        }
        return result;
    }

}
