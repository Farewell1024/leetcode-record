package com.zhangyu.leetcoderecord.problems;

/**
 * Function: Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @author zhangyu
 * Date: 2020/12/9 10:39
 * @since JDK 1.8
 */
public class Solution0050 {

    public static void main(String[] args) {
        Solution0050 solution = new Solution0050();
        System.out.println(solution.myPow2(2, 10));
        System.out.println(solution.myPow2(2.1, 3));
        System.out.println(solution.myPow2(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        // int的值不够用，需要转换成long（very important）
        long newN = n;
        if (newN < 0) {
            x = 1 / x;
            newN = -newN;
        }
        return quickPow(x, newN);
    }

    private double quickPow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double subResult = quickPow(x, n >> 1);
        return (n & 1) == 0 ? subResult * subResult : subResult * subResult * x;
    }


    public double myPow2(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        // int的值不够用，需要转换成long（very important）
        long newN = n;
        if (newN < 0) {
            x = 1 / x;
            newN = -newN;
        }
        return quickPow2(x, newN);
    }

    private double quickPow2(double x, long n) {
        double result = 1;
        double subResult = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= subResult;
            }
            subResult *= subResult;
            n >>= 1;
        }
        return result;
    }

}
