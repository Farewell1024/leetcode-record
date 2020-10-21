package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 72. 编辑距离
 *
 * @author zhangyu
 * Date: 2020/10/21 17:23
 * @since JDK 1.8
 */
public class Solution0072 {

    public static void main(String[] args) {
        Solution0072 solution = new Solution0072();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            result[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int up = result[i-1][j] + 1;
                int left = result[i][j-1] + 1;
                int xie = result[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0:1);
                result[i][j] = Math.min(up, Math.min(left, xie));
            }
        }
        return result[word1.length()][word2.length()];
    }
}
