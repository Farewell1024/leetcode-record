package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.*;

/**
 * Function: 15. 三数之和
 *
 * @author zhangyu
 * Date: 2021/3/1 13:53
 * @since JDK 1.8
 */
public class Solution0015 {

    public static void main(String[] args) {
        Solution0015 solution = new Solution0015();
        System.out.println(solution.threeSum3(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(solution.threeSum3(new int[]{-2,0,1,1,2}));
        System.out.println(solution.threeSum3(new int[]{0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    result.add(Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]));
                } else {
                    set.add(-nums[i]-nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 双指针
     *
     * 执行用时：34 ms, 在所有 Java 提交中击败了 19.45%的用户
     * 内存消耗：42.3 MB, 在所有 Java 提交中击败了71.36%的用户
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            for (int second = first + 1, third = nums.length - 1;second < third;) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second ++;
                    continue;
                }
                if (third < nums.length-1 && nums[third] == nums[third + 1]) {
                    third --;
                    continue;
                }
                if (nums[first] + nums[second] + nums[third] < 0) {
                    second ++;
                } else if (nums[first] + nums[second] + nums[third] > 0) {
                    third --;
                } else {
                    result.add(Arrays.asList(nums[first], nums[second ++], nums[third --]));
                }
            }
        }
        return result;
    }

    /**
     *
     * 执行用时：20 ms, 在所有 Java 提交中击败了99.00%的用户
     * 内存消耗：42.3 MB, 在所有 Java 提交中击败了73.41%的用户
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first] == nums[first-1]) continue;
            for (int second = first + 1, third = nums.length - 1;second < third;) {
                if (nums[first] + nums[second] + nums[third] < 0) {
                    second ++;
                } else if (nums[first] + nums[second] + nums[third] > 0) {
                    third --;
                } else {
                    result.add(Arrays.asList(nums[first], nums[second ++], nums[third --]));
                    while (second < third && nums[second] == nums[second - 1]) second ++;
                    while (second < third && nums[third] == nums[third + 1]) third --;
                }
            }
        }
        return result;
    }

}




















