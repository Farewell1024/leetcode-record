package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 35. 搜索插入位置
 *
 * @author zhangyu
 * Date: 6/9/21
 * @since JDK 1.8
 */
public class Solution0035 {

    public static void main(String[] args) {
        Solution0035 solution = new Solution0035();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
