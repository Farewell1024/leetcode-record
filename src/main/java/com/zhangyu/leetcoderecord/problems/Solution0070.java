package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 70. 爬楼梯
 *
 * @author zhangyu
 * Date: 2020/10/21 17:22
 * @since JDK 1.8
 */
public class Solution0070 {

    public static void main(String[] args) {
        Solution0070 solution = new Solution0070();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n-1];
    }

}
