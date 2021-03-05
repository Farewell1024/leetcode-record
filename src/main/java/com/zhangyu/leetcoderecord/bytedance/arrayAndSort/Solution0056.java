package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Function: 56. 合并区间
 *
 * @author zhangyu
 * Date: 2021/3/5 09:32
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

    /**
     * 排序后遍历
     * 根据数组的第一个元素进行排序
     * 排序之后遍历，如果当前值的开头小于等于基准值的结尾，就表明可以连接
     *
     * O(nlogn)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[k][1]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                intervals[++k] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, k + 1);
    }

}
