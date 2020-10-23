package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 231. 2的幂
 *
 * @author zhangyu
 * Date: 2020/10/23 15:10
 * @since JDK 1.8
 */
public class Solution0231 {

    public static void main(String[] args) {
        Solution0231 solution = new Solution0231();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}
