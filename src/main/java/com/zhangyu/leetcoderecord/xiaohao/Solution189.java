package com.zhangyu.leetcoderecord.xiaohao;

import java.util.Arrays;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 3/1/22
 * @since JDK 1.8
 */
public class Solution189 {

    public static void main(String[] args) {
        Solution189 solution = new Solution189();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate2(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
