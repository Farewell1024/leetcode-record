package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

/**
 * Function: 674. 最长连续递增序列
 *
 * @author zhangyu
 * Date: 2021/3/2 15:58
 * @since JDK 1.8
 */
public class Solution0674 {

    public static void main(String[] args) {
        Solution0674 solution = new Solution0674();
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    /**
     * 遍历一次
     *  [ 1, 3, 5, 4, 7]
     *  1 -> 3 -> 5 是有序数列的话， 3 -> 5 一定也是有序数列
     *  所以1 -> 3 -> 5 遍历完成之后，就无需再从3 -> 5
     *  使得时间复杂度从 n平方 降低到 n
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
