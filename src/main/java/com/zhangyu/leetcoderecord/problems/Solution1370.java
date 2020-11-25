package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 1370. 上升下降字符串
 *
 * @author zhangyu
 * Date: 2020/11/25 09:24
 * @since JDK 1.8
 */
public class Solution1370 {

    public static void main(String[] args) {
        Solution1370 solution = new Solution1370();
        System.out.println(solution.sortString("aaaabbbbcccc"));
        System.out.println(solution.sortString("rat"));
        System.out.println(solution.sortString("leetcode"));
        System.out.println(solution.sortString("ggggggg"));
        System.out.println(solution.sortString("spo"));
    }

    /**
     * 官方解法 1
     */
    public String sortString(String s) {
        int[] cache = new int[26];
        char[] result = new char[s.length()];
        // count
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a'] ++;
        }
        int index = 0;
        // generate result
        while (index < result.length) {
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] > 0) {
                    result[index ++] = (char) ('a' + i);
                    cache[i] --;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cache[i] > 0) {
                    result[index ++] = (char) ('a' + i);
                    cache[i] --;
                }
            }
        }
        return new String(result);
    }

}
