package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 26. 删除有序数组中的重复项
 *
 * @author zhangyu
 * Date: 2021/5/29
 * @since JDK 1.8
 */
public class Solution0026 {

    public static void main(String[] args) {
        Solution0026 solution = new Solution0026();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
