package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Function: 77. 组合
 *
 * @author zhangyu
 * Date: 2020/10/21 17:25
 * @since JDK 1.8
 */
public class Solution0077 {

    public static void main(String[] args) {
        Solution0077 solution = new Solution0077();
        System.out.println(solution.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> collect = Stream.iterate(1, i -> i + 1).limit(n).collect(Collectors.toList());
        combine(new ArrayList<>(collect), k, new ArrayList<>());
        return result;
    }

    private  List<List<Integer>> result = new ArrayList<>();

    public void combine(ArrayList<Integer> unused, int k, ArrayList<Integer> subResult){
        if (subResult.size() == k ){
            result.add(subResult);
            return;
        }
        for (int i = 0; i < unused.size(); i++) {
            ArrayList<Integer> cloneSubResult = (ArrayList<Integer>) subResult.clone();
            List<Integer> cloneUnused = unused.subList(i+1, unused.size());
            cloneSubResult.add(unused.get(i));
            combine(new ArrayList<>(cloneUnused), k, cloneSubResult);
        }
    }

}
