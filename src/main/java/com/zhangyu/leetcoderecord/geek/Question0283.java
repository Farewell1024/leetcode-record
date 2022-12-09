package com.zhangyu.leetcoderecord.geek;

import java.util.Arrays;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 11/24/22
 * @since JDK 1.8
 */
public class Question0283 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1};
        new Question0283().moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 遇到非零元素与0交换
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int snowball = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowball ++;
            } else if (snowball > 0) {
                nums[i - snowball] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
