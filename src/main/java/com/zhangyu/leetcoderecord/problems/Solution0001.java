package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Function:  1. 两数之和
 *
 * @author zhangyu
 * Date: 2020/10/15 13:48
 * @since JDK 1.8
 */
public class Solution0001 {

    public static void main(String[] args) {
        Solution0001 solution = new Solution0001();
        int[] result = solution.twosum(new int[]{2, 2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public int[] twosum (int[] nums, int target) {
        // key為值 value為數組index
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // 如果包含解，返回
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 不包含解，將值放入map
            if (! map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        throw new RuntimeException();
    }


}
