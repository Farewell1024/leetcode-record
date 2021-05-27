package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 461. 汉明距离
 *
 * @author zhangyu
 * Date: 2021/5/27
 * @since JDK 1.8
 */
public class Solution0461 {

    public static void main(String[] args) {
        Solution0461 solution = new Solution0461();
        System.out.println(solution.hammingDistance(1, 4));
        System.out.println(solution.hammingDistance2(1, 4));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y, result = 0;
        while (xor != 0) {
            xor &= xor - 1;
            result ++;
        }
        return result;
    }
}
