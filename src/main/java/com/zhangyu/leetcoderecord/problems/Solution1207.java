package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 1207. 独一无二的出现次数
 *
 * @author zhangyu
 * Date: 2020/10/28 09:40
 * @since JDK 1.8
 */
public class Solution1207 {

    public static void main(String[] args) {
        Solution1207 solution = new Solution1207();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(solution.uniqueOccurrences(new int[]{1,2}));
        System.out.println(solution.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    /**
     * 索然无味
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        return countMap.size() == new HashSet<>(countMap.values()).size();
    }
}
