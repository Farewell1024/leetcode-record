package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 477. 汉明距离总和
 *
 * @author zhangyu
 * Date: 2021/5/28
 * @since JDK 1.8
 */
public class Solution0477 {

    public static void main(String[] args) {
        Solution0477 solution = new Solution0477();
        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 2}));
    }

    /**
     * 暴力法
     */
    public int totalHammingDistance2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return result;
    }

    /**
     * 逐位统计
     * 记录数组中每一位1元素数量c，0则为数组长度-c，则该位的汉明距离为 c * (n - c)
     * 由于题目中元素大小范围，则统计前30位即可
     */
    public int totalHammingDistance(int[] nums) {
        int result = 0, n = nums.length;
        for (int i = 0; i < 30; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            result += count * (n - count);
        }
        return result;
    }
}
