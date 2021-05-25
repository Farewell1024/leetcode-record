package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 7. 整数反转
 *
 * @author zhangyu
 * Date: 2021/5/25
 * @since JDK 1.8
 */
public class Solution0007 {

    public static void main(String[] args) {
        Solution0007 solution = new Solution0007();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int high = x % 10;
            result = result * 10 + high;
            x /= 10;
        }
        return result;
    }

}
