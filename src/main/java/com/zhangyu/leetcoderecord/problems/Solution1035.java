package com.zhangyu.leetcoderecord.problems;

/**
 * Function:1035. 不相交的线
 *
 * @author zhangyu
 * Date: 2021/5/21
 * @since JDK 1.8
 */
public class Solution1035 {

    public static void main(String[] args) {
        Solution1035 solution = new Solution1035();
        System.out.println(solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
