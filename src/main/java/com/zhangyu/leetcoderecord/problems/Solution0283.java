package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 283. 移动零
 *
 * 要理解相对顺序的含义。相对顺序是指去除0之后的顺序，非自然增减顺序
 *
 * @author zhangyu
 * Date: 2020/11/3 17:13
 * @since JDK 1.8
 */
public class Solution0283 {

    public static void main(String[] args) {
        Solution0283 solution = new Solution0283();
        int[] ints = {0,1,0,3,12};
        solution.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
