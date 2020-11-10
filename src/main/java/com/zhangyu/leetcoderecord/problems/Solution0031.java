package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 31. 下一个排列
 *
 * @author zhangyu
 * Date: 2020/11/10 09:46
 * @since JDK 1.8
 */
public class Solution0031 {

    public static void main(String[] args) {
        Solution0031 solution = new Solution0031();
        int[] arr = {1, 2, 3};
        solution.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, 2, 1};
        solution.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 官方解法
     */
    public void nextPermutation(int[] nums) {
        // 从右向左 找到需要需要交换的值 --> 从右向左第一个非自增值
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i --;
        }
        // 找到需要交换的第二个值 --> 从右向左第一个大于i位置的值。
        // 如果找不到第一个值 则认为此序列已是最大，直接反转
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j --;
            }
            // 交换
            swap(nums, i, j);
        }
        // 反转
        reverse(nums, i+1);
    }

    /**
     * 反转数组
     */
    private void reverse(int[] nums, int i) {
        int end = nums.length-1;
        while (i < end){
            swap(nums, i, end);
            i++;
            end--;
        }
    }

    /**
     * 交换元素
     */
    public void swap(int [] nums, int first, int second){
        nums[first] ^= nums[second];
        nums[second] ^= nums[first];
        nums[first] ^= nums[second];
    }


}
