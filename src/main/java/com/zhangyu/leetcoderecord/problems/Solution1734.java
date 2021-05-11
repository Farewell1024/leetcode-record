package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 1734. 解码异或后的排列
 *
 * @author zhangyu
 * Date: 2021/5/11
 * @since JDK 1.8
 */
public class Solution1734 {

    public static void main(String[] args) {
        Solution1734 solution = new Solution1734();
        System.out.println(Arrays.toString(solution.decode(new int[]{3, 1})));
        System.out.println(Arrays.toString(solution.decode(new int[]{6, 5, 4, 6})));
    }

    /**
     * 题目中"perm是n个正整数的排列"，这句话为重中之重
     * 1. 所以perm每个元素的的 异或 结果为 1->encode.length + 1
     * 2. perm中除去第一个元素的所有元素 异或 结果为encode数组中奇数下标元素异或结果
     * 3. 由1，2可得出，perm数组中下标为0的元素
     * 4. 根据encode数组和perm下标为0的元素计算出perm数组中每个值
     */
    public int[] decode(int[] encoded) {
        int total = 0, odd = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            total ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            odd ^= encoded[i];
        }
        int[] result = new int[encoded.length + 1];
        result[0] = total ^ odd;
        for (int i = 1; i < result.length; i++) {
            result[i] = encoded[i - 1] ^ result[i - 1];
        }
        return result;
    }

}
