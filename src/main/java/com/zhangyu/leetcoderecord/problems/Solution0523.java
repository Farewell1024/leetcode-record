package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 523. 连续的子数组和
 *
 * @author zhangyu
 * Date: 6/2/21
 * @since JDK 1.8
 */
public class Solution0523 {

    public static void main(String[] args) {
        Solution0523 solution = new Solution0523();
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(solution.checkSubarraySum(new int[]{5, 0, 0, 0}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{6}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23,2,4,6,6}, 7));
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            int c = prefix[i] % k;
            if (cache.containsKey(c)) {
                Integer pre = cache.get(c);
                if (i - pre >= 2) {
                    return true;
                }
            } else {
                cache.put(c, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, -1);
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c = (c + nums[i]) % k;
            if (cache.containsKey(c)) {
                if (i - cache.get(c) >= 2) {
                    return true;
                }
            } else {
                cache.put(c, i);
            }
        }
        return false;
    }
}
