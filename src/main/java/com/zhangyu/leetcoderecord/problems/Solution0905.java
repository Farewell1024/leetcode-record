package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 905. 按奇偶排序数组
 *
 * @author zhangyu
 * Date: 2020/11/12 10:20
 * @since JDK 1.8
 */
public class Solution0905 {

    public static void main(String[] args) {
        Solution0905 solution = new Solution0905();
        System.out.println(Arrays.toString(solution.sortArrayByParity2(new int[]{3, 2, 1, 4})));
        System.out.println(Arrays.toString(solution.sortArrayByParity2(new int[]{0})));
        System.out.println(Arrays.toString(solution.sortArrayByParity2(new int[]{})));
        System.out.println(Arrays.toString(solution.sortArrayByParity2(new int[]{0, 1, 2})));
        System.out.println(Arrays.toString(solution.sortArrayByParity2(new int[]{1, 3})));
    }

    /**
     * 将结果添加到新数组 （类似官方解法2）
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i : A) {
            if ((i & 1) == 0) {
                result[start ++] = i;
            } else {
                result[end --] = i;
            }
        }
        return result;
    }

    /**
     * 修改原数组  （官方解法3）
     */
    public int[] sortArrayByParity2(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            if ((A[start] & 1) > (A[end] & 1)) {
                A[start] ^= A[end];
                A[end] ^= A[start];
                A[start] ^= A[end];
            }
            if ((A[start] & 1) == 0) {
                start++;
            }
            if ((A[end] & 1) == 1) {
                end--;
            }
        }
        return A;
    }

}
