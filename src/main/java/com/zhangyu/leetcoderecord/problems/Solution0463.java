package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 463. 岛屿的周长
 *
 * @author zhangyu
 * Date: 2020/10/30 09:51
 * @since JDK 1.8
 */
public class Solution0463 {

    public static void main(String[] args) {
        Solution0463 solution = new Solution0463();
        System.out.println(solution.islandPerimeter(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0}
        }));
    }

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0){
                    continue;
                }
                int count = 4;
                // left
                if (j>0 && grid[i][j-1] == 1){
                    count -- ;
                }
                // right
                if (j<grid[i].length -1 && grid[i][j+1] == 1){
                    count --;
                }
                // up
                if (i>0 && grid[i-1][j] == 1){
                    count --;
                }
                // down
                if (i<grid.length-1 && grid[i+1][j] == 1){
                    count --;
                }
                result += count;
            }
        }
        return result;
    }

}
