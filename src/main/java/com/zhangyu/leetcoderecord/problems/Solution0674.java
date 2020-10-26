package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 674. 最长连续递增序列
 *
 * @author zhangyu
 * Date: 2020/10/26 10:40
 * @since JDK 1.8
 */
public class Solution0674 {

    public static void main(String[] args) {
        Solution0674 solution = new Solution0674();
        System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 1;
        int previous = nums[0];
        int previousMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > previous) {
                previousMax ++;
                result = Math.max(result, previousMax);
            } else {
                previousMax =1;
            }
            previous = nums[i];
        }
        return result;
    }
}
