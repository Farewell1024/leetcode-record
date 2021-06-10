package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 27. Remove Element
 *
 * @author zhangyu
 * Date: 6/6/21
 * @since JDK 1.8
 */
public class Solution0027 {

    public static void main(String[] args) {
        Solution0027 solution = new Solution0027();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

}
