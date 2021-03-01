package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

/**
 * Function: 33. 搜索旋转排序数组
 *
 * @author zhangyu
 * Date: 2021/3/1 16:52
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

    /**
     * 二分查找
     *
     * 取中的时候 1～mid 和 mid～length-1中总有一个是有序的
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target > nums[0] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
