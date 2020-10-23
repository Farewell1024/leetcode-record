package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Function: 300. 最长上升子序列
 *
 * @author zhangyu
 * Date: 2020/10/23 16:40
 * @since JDK 1.8
 */
public class Solution0300 {

    public static void main(String[] args) {
        Solution0300 solution = new Solution0300();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty() || nums[i] > list.get(list.size() -1)) {
                list.add(nums[i]);
            } else {
                int index = Arrays.binarySearch(list.stream().mapToInt(Integer::intValue).toArray(), nums[i]);
                if (index < 0){
                    list.set(-index -1, nums[i]);
                }
            }
        }
        return list.size();
    }
}
