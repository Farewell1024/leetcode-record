package com.zhangyu.leetcoderecord.unfinished;

/**
 * Function: 493. 翻转对
 *
 * @author zhangyu
 * Date: 2020/12/10 14:27
 * @since JDK 1.8
 */
public class Solution0493 {

    public static void main(String[] args) {
        Solution0493 solution = new Solution0493();
        System.out.println(solution.reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));
        System.out.println(solution.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }

    /**
     * 暴力法 （超出时间限制）
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        if (nums.length <= 1) {
            return count;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] / 2.0 > nums[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

}
