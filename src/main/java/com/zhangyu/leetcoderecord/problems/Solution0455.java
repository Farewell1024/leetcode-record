package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 455. 分发饼干
 *
 * @author zhangyu
 * Date: 2020/12/14 10:22
 * @since JDK 1.8
 */
public class Solution0455 {

    public static void main(String[] args) {
        Solution0455 solution = new Solution0455();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    /**
     * 贪心算法
     *
     * @param g 小孩胃口
     * @param s 饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && g[i] <= s[index]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
