package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 922. 按奇偶排序数组 II
 *
 * @author zhangyu
 * Date: 2020/11/12 09:38
 * @since JDK 1.8
 */
public class Solution0922 {

    public static void main(String[] args) {
        Solution0922 solution = new Solution0922();
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(solution.sortArrayByParityII2(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(solution.sortArrayByParityII2(new int[]{5, 4})));
        System.out.println(Arrays.toString(solution.sortArrayByParityII2(new int[]{})));
        System.out.println(Arrays.toString(solution.sortArrayByParityII2(new int[]{1,4,4,3,0,3})));
        System.out.println("耗时 ：" + (System.currentTimeMillis() - start));
    }

    /**
     * 双指针 方法 （自己实现的，写得不太好）
     */
    public int[] sortArrayByParityII(int[] A) {
        int left = 0;
        int right = 1;
        while (left < A.length && right < A.length) {
            while (left < A.length && (A[left] & 1) == 0) {
                left += 2;
            }
            while (right < A.length && (A[right] & 1) == 1) {
                right += 2;
            }
            if (left < A.length && right < A.length) {
                A[left] ^= A[right];
                A[right] ^= A[left];
                A[left] ^= A[right];
            }
        }
        return A;
    }

    /**
     * 官方题解1  遍历
     */
    public int[] sortArrayByParityII2(int[] A) {
        int[] result = new int[A.length];
        int a = 0, b = 1;
        for (int i : A) {
            if ((i & 1) == 0) {
                result[a] = i;
                a += 2;
            } else {
                result[b] = i;
                b += 2;
            }
        }
        return result;
    }


}
