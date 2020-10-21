package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 66. 加一
 *
 * @author zhangyu
 * Date: 2020/10/21 17:02
 * @since JDK 1.8
 */
public class Solution0066 {

    public static void main(String[] args) {
        Solution0066 solution = new Solution0066();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {
        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += tmp;
            tmp = digits[i] / 10;
            if (tmp == 0) {
                break;
            }
            digits[i] %= 10;
        }
        if (tmp != 0 ){
            digits = new int[digits.length + 1];
            digits[0] = tmp;
        }
        return digits;
    }
}
