package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 322. 零钱兑换
 *
 * @author zhangyu
 * Date: 2020/10/23 16:47
 * @since JDK 1.8
 */
public class Solution0322 {

    public static void main(String[] args) {
        Solution0322 solution = new Solution0322();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{1}, 1));
        System.out.println(solution.coinChange(new int[]{1}, 2));
    }

    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length ; j++) {
                if (coins[j] <= i)
                    result[i] = Math.min(result[i], result[i - coins[j]] + 1);
            }
        }
        return result[amount] > amount? -1 : result[amount];
    }
}
