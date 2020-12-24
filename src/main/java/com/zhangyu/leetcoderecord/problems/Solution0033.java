package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 33. 搜索旋转排序数组
 *
 * @author zhangyu
 * Date: 2020/12/15 10:36
 * @since JDK 1.8
 */
public class Solution0033 {

    public static void main(String[] args) {
        Solution0033 solution = new Solution0033();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1}, 0));
        System.out.println(solution.search(new int[]{5, 1, 3}, 5));

    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧有序
            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
