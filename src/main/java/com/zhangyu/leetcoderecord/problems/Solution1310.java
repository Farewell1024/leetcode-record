package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 1310. 子数组异或查询
 *
 * @author zhangyu
 * Date: 2021/5/12
 * @since JDK 1.8
 */
public class Solution1310 {

    public static void main(String[] args) {
        Solution1310 solution = new Solution1310();
        System.out.println(Arrays.toString(solution.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
        System.out.println(Arrays.toString(solution.xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}})));
    }

    /**
     * 官方题解
     *
     * 使用一个cache数组将前缀异或结果缓存起来
     * 利用异或特性，在求范围的时候，异或缓存中左边界下标对应的值和后边界下标+1对应的值（因为cache数组长度比arr大一）
     * cache数组长度比arr数组大一，是因为在进行计算的时候，不需要额外考虑左边届为0的情况
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] cache = new int[arr.length + 1], result = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            cache[i + 1] = cache[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = cache[queries[i][0]] ^ cache[queries[i][1] + 1];
        }
        return result;
    }

    /**
     * 两次遍历计算
     * O(n*m)
     */
    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int total = 0;
            for (int j = queries[i][0]; j <= queries[i][1] ; j++) {
                total ^= arr[j];
            }
            result[i] = total;
        }
        return result;
    }
}
