package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 338. 比特位计数
 *
 * @author zhangyu
 * Date: 2020/10/23 16:51
 * @since JDK 1.8
 */
public class Solution0338 {

    public static void main(String[] args) {
        Solution0338 solution = new Solution0338();
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i-1)] + 1;
        }
        return result;
    }
}
