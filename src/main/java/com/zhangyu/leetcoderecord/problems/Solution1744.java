package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 *
 * @author zhangyu
 * Date: 6/1/21
 * @since JDK 1.8
 */
public class Solution1744 {

    public static void main(String[] args) {
        Solution1744 solution = new Solution1744();
        System.out.println(Arrays.toString(solution.canEat(new int[]{7, 4, 5, 3, 8},
                new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}})));
        System.out.println(Arrays.toString(solution.canEat(new int[]{5, 2, 6, 4, 1},
                new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}})));
    }

    /**
     *看題解吧
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        long[] prefix = new long[candiesCount.length];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0], favoriteDay = queries[i][1], dailyCap = queries[i][2];
            // favorite day
            long l1 = favoriteDay + 1;
            long r1 = l1 * dailyCap;
            // favorite type
            long l2 = favoriteType == 0 ? 1 : prefix[favoriteType - 1] + 1;
            long r2 = prefix[favoriteType];
            result[i] = !((r1 < l2) || (r2 < l1));
        }
        return result;
    }
}
