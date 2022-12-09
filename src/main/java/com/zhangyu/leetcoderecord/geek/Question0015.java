package com.zhangyu.leetcoderecord.geek;

import java.util.*;

/**
 * Function: 3Sum
 *
 * @author Yu Zhang
 * Date: 11/28/22
 * @since JDK 1.8
 */
public class Question0015 {

    public static void main(String[] args) {
        System.out.println(new Question0015().threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(new Question0015().threeSum(new int[]{0,1,1}));
        System.out.println(new Question0015().threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j = calJ(nums, j, k);
                    k = calK(nums, j, k);
                } else if (sum > 0) {
                    k = calK(nums, j, k);
                } else {
                    j = calJ(nums, j, k);
                }
            }
        }
        return result;
    }

    private int calK(int[] nums, int j, int k) {
        while (j < k && nums[k - 1] == nums[k]) {
            k --;
        }
        return --k;
    }

    private int calJ(int[] nums, int j, int k) {
        while (j < k && nums[j] == nums[j+1]) {
            j++;
        }
        return ++j;
    }

}
