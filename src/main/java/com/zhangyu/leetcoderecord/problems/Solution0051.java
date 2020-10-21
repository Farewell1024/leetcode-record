package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Function:  51. N 皇后
 *
 * @author zhangyu
 * Date: 2020/10/21 16:56
 * @since JDK 1.8
 */
public class Solution0051 {

    public static void main(String[] args) {
        Solution0051 solution = new Solution0051();
        System.out.println(solution.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        dfs(n, 0, 0,0,0, new int[n]);
        return parseResult(result, n);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public void dfs(int n, int row, int col, int pie, int na, int[] result){
        if (row >= n){
            this.result.add(IntStream.of(result).map(x -> (int)(Math.log(x)/ Math.log(2))).boxed().collect(Collectors.toList()));
            return;
        }
        int blank = (~(col | pie | na)) & ((1<<n )-1);
        while (blank > 0) {
            int a = blank & (-blank);
            result[row] = a;
            dfs(n, row+1, col|a, (pie | a)<<1, (na | a) >> 1, result);
            blank = blank & (blank -1);
            result[row] = 0;
        }
    }

    public List<List<String>> parseResult(List<List<Integer>> result, int n){
        return result.stream().map(x -> x.stream().map(y -> {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[y] = 'Q';
            return new String(chars);
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
