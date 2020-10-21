package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 39. 组合总和
 *
 * @author zhangyu
 * Date: 2020/10/21 15:16
 * @since JDK 1.8
 */
public class Solution0039 {

    public static void main(String[] args) {
        Solution0039 solution = new Solution0039();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }


    public void combinationSum(int[] candidates, int target, List<Integer> subResult, int index, List<List<Integer>> result) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        // not check
        combinationSum(candidates, target, subResult, index + 1, result);
        // check
        if (candidates[index] <= target) {
            subResult.add(candidates[index]);
            combinationSum(candidates, target-candidates[index], subResult, index, result);
            subResult.remove(subResult.size() -1);
        }
    }

}
