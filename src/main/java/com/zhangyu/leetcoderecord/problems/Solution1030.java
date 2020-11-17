package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Function: 1030. 距离顺序排列矩阵单元格
 *
 * @author zhangyu
 * Date: 2020/11/17 09:34
 * @since JDK 1.8
 */
public class Solution1030 {

    public static void main(String[] args) {
        Solution1030 solution = new Solution1030();
        System.out.println(Arrays.stream(solution.allCellsDistOrder(1, 2, 0, 0)).map(Arrays::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(solution.allCellsDistOrder(2, 2, 0, 1)).map(Arrays::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(solution.allCellsDistOrder(2, 3, 1, 2)).map(Arrays::toString).collect(Collectors.joining(", ")));
    }

    /**
     * 官方解法1，直接排序
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[C * R][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[index ++] = new int[]{i, j};
            }
        }
        Arrays.sort(result, Comparator.comparingInt(o -> Math.abs(o[0] - r0) + Math.abs(o[1] - c0)));
        return result;
    }
}
