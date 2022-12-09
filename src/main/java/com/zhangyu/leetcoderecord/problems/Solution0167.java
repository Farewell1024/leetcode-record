package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 167. Two Sum II - Input array is sorted
 *
 * @author zhangyu
 * Date: 7/15/21
 * @since JDK 1.8
 */
public class Solution0167 {

    public static void main(String[] args) {
        Solution0167 solution = new Solution0167();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1)));
    }

    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int start = 0, end = numbers.length - 1; start < end; ) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end --;
            } else {
                start ++;
            }
        }
        return new int[]{-1, -1};
    }

}
