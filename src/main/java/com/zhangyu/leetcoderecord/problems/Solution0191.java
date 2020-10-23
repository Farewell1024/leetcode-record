package com.zhangyu.leetcoderecord.problems;

/**
 * Function:  191. 位1的个数
 *
 * @author zhangyu
 * Date: 2020/10/23 11:54
 * @since JDK 1.8
 */
public class Solution0191 {

    public static void main(String[] args) {
        Solution0191 solution = new Solution0191();
        System.out.println(solution.hammingWeight(-1));
        System.out.println(solution.hammingWeight(3));
    }

    public int hammingWeight(int n) {
        int num = 0 ;
        while (n != 0) {
            n = n & (n-1);
            num ++;
        }
        return num;
    }
}
