package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Function: 78. 子集
 *
 * @author zhangyu
 * Date: 2020/10/21 17:26
 * @since JDK 1.8
 */
public class Solution0078 {

    public static void main(String[] args) {
        Solution0078 solution = new Solution0078();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, new ArrayList<>(), 0);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, List<Integer> subResult, int index){
        if (index == nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        //dont check
        helper(result, nums, subResult, index+1);
        //check
        subResult.add(nums[index]);
        helper(result, nums, subResult, index+1);
        subResult.remove(subResult.size() -1 );
    }
}
