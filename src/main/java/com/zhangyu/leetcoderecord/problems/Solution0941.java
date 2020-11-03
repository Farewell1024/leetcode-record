package com.zhangyu.leetcoderecord.problems;

/**
 * Function:  941. 有效的山脉数组
 *
 * @author zhangyu
 * Date: 2020/11/3 09:16
 * @since JDK 1.8
 */
public class Solution0941 {

    public static void main(String[] args) {
        Solution0941 solution = new Solution0941();
        System.out.println(solution.validMountainArray(new int[]{2, 1}));
        System.out.println(solution.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(solution.validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));
        System.out.println(solution.validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}));
        System.out.println(solution.validMountainArray(new int[]{2, 0, 2}));
    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int top = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                top = i-1;
                break;
            }
        }
        for (int i = top; i < A.length-1; i++) {
            if (A[i] <= A[i+1]) {
                return false;
            }
        }
        return top != 0;
    }
}
