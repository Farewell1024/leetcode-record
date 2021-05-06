package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 1720. 解码异或后的数组
 *
 * @author zhangyu
 * Date: 2021/5/6
 * @since JDK 1.8
 */
public class Solution1720 {

    public static void main(String[] args) {
        Solution1720 solution = new Solution1720();
        System.out.println(Arrays.toString(solution.decode(new int[]{1,2,3}, 1)));
        System.out.println(Arrays.toString(solution.decode(new int[]{6,2,7,3}, 4)));
    }

    /**
     * 利用异或的特性 a^b=c，那么 a^c=b
     */
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }
}
