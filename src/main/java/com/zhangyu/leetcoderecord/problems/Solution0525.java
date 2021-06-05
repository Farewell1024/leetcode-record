package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 525. 连续数组
 *
 * @author zhangyu
 * Date: 6/3/21
 * @since JDK 1.8
 */
public class Solution0525 {

    public static void main(String[] args) {
        Solution0525 solution = new Solution0525();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        int sum = 0, result = 0;
        cache.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum --;
            } else {
                sum ++;
            }
            if (cache.containsKey(sum)) {
                result = Math.max(result, i - cache.get(sum));
            } else {
                cache.put(sum, i);
            }
        }
        return result;
    }
}
