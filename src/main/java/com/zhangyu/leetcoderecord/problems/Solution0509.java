package com.zhangyu.leetcoderecord.problems;

import java.util.stream.IntStream;

/**
 * Function: 509. 斐波那契数
 *
 * @author zhangyu
 * Date: 2020/10/23 17:03
 * @since JDK 1.8
 */
public class Solution0509 {

    public static void main(String[] args) {
        Solution0509 solution = new Solution0509();
        IntStream.rangeClosed(0, 15).forEach(x -> System.out.println(x + " : " + solution.fib(x)));
    }

    public int fib(int N) {
        if (N<=1) {return N; }
        int a = 0, b=1, result=0;
        for (int i = 2; i < N+1; i++) {
            result = a+b;
            a = b;
            b = result;
        }
        return result;
    }
}
