package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.LinkedList;

/**
 * Function: 695. 岛屿的最大面积
 *
 * @author zhangyu
 * Date: 2021/3/1 15:23
 * @since JDK 1.8
 */
public class Solution0695 {

    public static void main(String[] args) {
        Solution0695 solution = new Solution0695();
        System.out.println(solution.maxAreaOfIsland2(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
        System.out.println(solution.maxAreaOfIsland2(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    /**
     * 递归判断与1连接的四个方向是不是1， 访问过的土地置为0
     * 这样会对原数组造成改变
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了79.31%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了16.60%的用户
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i ,j));
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 ) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + helper(grid,x-1, y)
                + helper(grid, x+1, y)
                + helper(grid, x, y-1)
                + helper(grid, x, y+1);
    }

    /**
     * 手动维护栈 深度优先
     * 如果改成队列 即为广度优先
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    LinkedList<int[]> stack = new LinkedList<>();
                    stack.push(new int[] {i, j});
                    while (! stack.isEmpty()) {
                        int[] coordinate = stack.pop();
                        if (coordinate[0] < 0 || coordinate[0] >= grid.length || coordinate[1] < 0 || coordinate[1] >= grid[0].length || grid[coordinate[0]][coordinate[1]] == 0) {
                            continue;
                        }
                        grid[coordinate[0]][coordinate[1]] = 0;
                        count ++;
                        stack.push(new int[] { coordinate[0] + 1, coordinate[1]});
                        stack.push(new int[] { coordinate[0] - 1, coordinate[1]});
                        stack.push(new int[] { coordinate[0], coordinate[1] + 1});
                        stack.push(new int[] { coordinate[0], coordinate[1] - 1});
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }


}
