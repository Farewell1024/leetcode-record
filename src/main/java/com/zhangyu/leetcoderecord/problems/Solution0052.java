package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 52. N皇后 II
 *
 * @author zhangyu
 * Date: 2020/10/21 17:00
 * @since JDK 1.8
 */
public class Solution0052 {

    public static void main(String[] args) {
        Solution0052 solution = new Solution0052();
        System.out.println(solution.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private int count = 0;

    private void dfs(int n, int row, int col, int pie, int na){
        if (row >= n){
            count ++;
            return;
        }
        int blank = (~(col | pie | na)) & ((1<<n )-1);
        while (blank > 0) {
            int a = blank & (-blank);
            dfs(n, row+1, col|a, (pie | a)<<1, (na | a) >> 1);
            blank = blank & (blank -1);
        }
    }
}
