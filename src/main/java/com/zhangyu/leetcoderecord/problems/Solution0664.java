package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 664. 奇怪的打印机
 *
 * @author zhangyu
 * Date: 2021/5/24
 * @since JDK 1.8
 */
public class Solution0664 {

    public static void main(String[] args) {
        Solution0664 solution = new Solution0664();
        System.out.println(solution.strangePrinter("aaabbb"));
        System.out.println(solution.strangePrinter("aba"));
    }

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }
}
