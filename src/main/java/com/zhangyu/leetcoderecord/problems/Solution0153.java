package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 153. 寻找旋转排序数组中的最小值
 *
 * @author zhangyu
 * Date: 2021/4/8 15:36
 * @since JDK 1.8
 */
public class Solution0153 {

    public static void main(String[] args) {
        Solution0153 solution = new Solution0153();
        System.out.println(solution.findMin(new int[]{3,4,5,1,2}));
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(solution.findMin(new int[]{0,1,2,4,5,6,7}));
        System.out.println(solution.findMin(new int[]{3,1,2}));
    }

    /**
     * 折线
     *          5
     *      4
     *  3
     *                  2
     *              1
     */
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

}
