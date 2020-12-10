package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Function: 56. 合并区间
 *
 * @author zhangyu
 * Date: 2020/12/10 11:13
 * @since JDK 1.8
 */
public class Solution0056 {

    public static void main(String[] args) {
        Solution0056 solution = new Solution0056();
        int[][] merge = solution.merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        });
        Arrays.stream(merge).map(Arrays::toString).forEach(System.out::println);

        System.out.println("-====================================");

        int[][] intervals = solution.merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
        });
        Arrays.stream(intervals).map(Arrays::toString).forEach(System.out::println);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] < intervals[i][0]){
                intervals[++k] = intervals[i];
            } else {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(intervals, k + 1);
    }

}
