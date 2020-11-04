package com.zhangyu.leetcoderecord.unfinished;

import java.util.Arrays;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2020/11/3 17:13
 * @since JDK 1.8
 */
public class Solution0283 {

    public static void main(String[] args) {
        Solution0283 solution = new Solution0283();
        int[] ints = {0,1,0,3,12};
//        int[] ints = {0};
        solution.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int bound = nums.length - 1;
        for (int i = 0; i <= bound; i++) {
            while (bound > 0 && nums[bound] == 0){
                bound --;
            }
            if (nums[i] == 0) {
                nums[i] = nums[bound];
                nums[bound --] = 0;
            }
            int tmp = i;
            while (tmp>0 && nums[tmp] < nums[tmp-1]){
               int in = nums[tmp];
               nums[tmp] = nums[tmp - 1];
               nums[tmp-1] = in;
            }
        }
    }

}
