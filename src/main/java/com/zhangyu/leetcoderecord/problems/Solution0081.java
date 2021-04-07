package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 81. 搜索旋转排序数组 II
 *
 * @author zhangyu
 * Date: 2021/4/7 15:40
 * @since JDK 1.8
 */
public class Solution0081 {

    public static void main(String[] args) {
        Solution0081 solution = new Solution0081();
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(solution.search(new int[]{3, 1, 2, 3, 3, 3, 3}, 2));
    }

    /**
     * 二分查找 思路参见33题
     *
     * 值得注意的是：
     */
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

}
