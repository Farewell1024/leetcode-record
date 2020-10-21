package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Function: 120. 三角形最小路径和
 *
 * @author zhangyu
 * Date: 2020/10/21 18:04
 * @since JDK 1.8
 */
public class Solution0120 {

    public static void main(String[] args) {
        Solution0120 solution = new Solution0120();
        System.out.println(solution.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        )));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] mini = triangle.get(triangle.size() -1).stream().mapToInt(Integer::intValue).toArray();
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j+1]);
            }
        }
        return mini[0];
    }
}
