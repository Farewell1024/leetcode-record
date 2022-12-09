package com.zhangyu.leetcoderecord.geek;

/**
 * Function:  Climbing Stairs
 *
 * @author zhangyu
 * Date: 11/27/22
 * @since JDK 1.8
 */
public class Question0070 {

    public static void main(String[] args) {
        System.out.println(new Question0070().climbStairs(2));
        System.out.println(new Question0070().climbStairs(3));
        System.out.println(new Question0070().climbStairs(4));
        System.out.println(new Question0070().climbStairs(5));
    }

    /**
     *
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

}
