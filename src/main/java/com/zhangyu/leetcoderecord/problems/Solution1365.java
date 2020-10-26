package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: 1365. 有多少小于当前数字的数字
 *
 * @author zhangyu
 * Date: 2020/10/26 09:49
 * @since JDK 1.8
 */
public class Solution1365 {

    public static void main(String[] args) {
        Solution1365 solution = new Solution1365();
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{6,5,4,8})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{7,7,7,7})));

    }

    /**
     * 使用Map计数
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null) {return nums;}
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]){
                count.put(nums[i], i);
            }
        }
        count.put(nums[0], 0);
        for (int i = 0; i < result.length; i++) {
            result[i] = count.get(result[i]);
        }
        return result;
    }

}
