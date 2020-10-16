package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function:  977. 有序数组的平方
 *
 * @author zhangyu
 * Date: 2020/10/16 09:56
 * @since JDK 1.8
 */
public class Solution0977 {
    public static void main(String[] args) {
        Solution0977 solution = new Solution0977();
        int[] result = solution.sortedSquares2(new int[]{-7,-3,2,3,11});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 直接排序
     */
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return null;
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 双指针
     */
    public int[] sortedSquares2(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] result = new int[A.length];
        for (int left=0, right = A.length -1, pos = right;left <= right; pos --) {
            if (A[left] * A[left] > A[right] * A[right]) {
                result[pos] = A[left] * A[left];
                left ++;
            }else {
                result[pos] = A[right] * A[right];
                right --;
            }
        }
        return result;
    }



}
