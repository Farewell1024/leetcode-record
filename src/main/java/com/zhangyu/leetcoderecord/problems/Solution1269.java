package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 1269. 停在原地的方案数
 *
 * @author zhangyu
 * Date: 2021/5/13
 * @since JDK 1.8
 */
public class Solution1269 {

    public static void main(String[] args) {
        Solution1269 solution = new Solution1269();
        System.out.println(solution.numWays(3, 2));
        System.out.println(solution.numWays(2, 4));
        System.out.println(solution.numWays(4, 2));
        System.out.println(solution.numWays(27, 7));
    }

    /**
     * 动态规划
     *
     */
    public int numWays(int steps, int arrLen) {
        final int MOD = 1000000007;
        int index = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][index + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= index; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
                }
                if (j < index) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MOD;
                }
            }
        }
        return dp[steps][0];
    }

    /**
     * 自己实现的深度优先遍历，会超时
     */
    public int numWays2(int steps, int arrLen) {
        result = 0;
        helper(steps, arrLen, 0);
        return (int) (result % (10_0000_0007));
    }

    private long result;

    public void helper(int leftSteps, int arrlen, int current) {
        if (leftSteps == 0) {
            if (current == 0) {
                result++;
            }
            return;
        }
        // left
        if (current > 0) {
            helper(leftSteps - 1, arrlen, current - 1);
        }
        // don't move
        helper(leftSteps - 1, arrlen, current);
        // right
        if (current < arrlen - 1) {
            helper(leftSteps - 1, arrlen, current + 1);
        }
    }

}
