package com.zhangyu.leetcoderecord.problems.unfinished;

import java.util.Arrays;

/**
 * Function: 57. 插入区间
 *
 * @author zhangyu
 * Date: 2020/11/4 09:33
 * @since JDK 1.8
 */
public class Solution0057 {

    public static void main(String[] args) {

        Thread.interrupted();
        new Thread().interrupt();

        Solution0057 solution = new Solution0057();
        Arrays.stream(solution.insert(new int[][]{
                new int[]{1, 3},
                new int[]{6, 9}
        }, new int[]{2, 5})).forEach(x -> System.out.println(Arrays.toString(x)));
         System.out.println("===================================================");
        Arrays.stream(solution.insert(new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16}
        }, new int[]{4, 8})).forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("===================================================");
        Arrays.stream(solution.insert(new int[][]{
                new int[]{1, 2}
        }, new int[]{4, 8})).forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("===================================================");
        Arrays.stream(solution.insert(new int[][]{
                new int[]{1, 5}
        }, new int[]{4, 8})).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int intersect = 0;
        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int itermLeft = intervals[i][0];
            int itermRight = intervals[i][1];
            if ((itermLeft >= newLeft && itermLeft <= newRight) || (itermRight >= newLeft && itermRight <= newRight)) {
                intervals[intersect][0] = Math.min(intervals[i][0], Math.min(newLeft, intervals[intersect][0]));
                intervals[intersect][1] = Math.max(intervals[i][1], Math.max(newRight, intervals[intersect][1]));
            } else if (newLeft > itermRight){
                ++ intersect;
            } else if (newRight < itermLeft){
                intervals[++ intersect] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, intersect+1);
    }
}
