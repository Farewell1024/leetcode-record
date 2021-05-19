package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 1738. 找出第 K 大的异或坐标值
 *
 * @author zhangyu
 * Date: 2021/5/19
 * @since JDK 1.8
 */
public class Solution1738 {

    public static void main(String[] args) {
        Solution1738 solution = new Solution1738();
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        System.out.println(solution.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, index = 0;
        int[][] suffix = new int[m + 1][n + 1];
        int[] cache = new int[m * n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                suffix[i][j] = suffix[i-1][j] ^ suffix[i][j-1] ^ suffix[i-1][j-1] ^ matrix[i-1][j-1];
                cache[index ++] = suffix[i][j];
            }
        }
        Arrays.sort(cache);
        return cache[cache.length - k];
    }
}

