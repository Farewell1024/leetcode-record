package com.zhangyu.leetcoderecord.geek;

import java.util.*;

/**
 * Function: Two Sum
 *
 * @author Yu Zhang
 * Date: 11/28/22
 * @since JDK 1.8
 */
public class Question0001 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question0001().twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(new Question0001().twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(new Question0001().twoSum(new int[]{3,3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{i, cache.get(target - nums[i])};
            }
            cache.put(nums[i], i);
        }
        throw new RuntimeException();
    }
}
