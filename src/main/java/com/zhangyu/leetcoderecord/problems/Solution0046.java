package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Function: 46. 全排列
 *
 * @author zhangyu
 * Date: 2020/10/21 15:21
 * @since JDK 1.8
 */
public class Solution0046 {

    public static void main(String[] args) {
        Solution0046 solution = new Solution0046();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute2(nums.length, 0, IntStream.of(nums).boxed().collect(Collectors.toList()), result);
        return result;
    }

    public void permute2(int n, int index, List<Integer> subResult, List<List<Integer>> result) {
        if (index == n){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for (int i = index; i < n; i++) {
            Collections.swap(subResult, index, i);
            permute2(n, index+1, subResult, result);
            Collections.swap(subResult, i, index);
        }
    }
}
