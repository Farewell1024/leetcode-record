package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 15. 三数之和
 *
 * @author zhangyu
 * Date: 2020/10/15 16:09
 * @since JDK 1.8
 */
public class Solution0015 {
    public static void main(String[] args) {
        Solution0015 solution = new Solution0015();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * Set 解法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length; j++){
                if (! set.contains(nums[j])){
                    set.add(-nums[i]-nums[j]);
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i+1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end --;
                }else if (nums[i] + nums[start] + nums[end] < 0) {
                    start ++ ;
                }else {
                    result.add(Arrays.asList(nums[i] , nums[start] , nums[end]));
                    while (start < end &&nums[start + 1] == nums[start]) {
                        start++;
                    }
                    while (start < end && nums[end-1] == nums[end]) {
                        end -- ;
                    }
                    start ++;
                    end -- ;
                }
            }
        }
        return result;
    }


}
