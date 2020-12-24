package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 541. 反转字符串 II
 *
 * @author zhangyu
 * Date: 2020/12/24 10:09
 * @since JDK 1.8
 */
public class Solution0541 {

    public static void main(String[] args) {
        Solution0541 solution = new Solution0541();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }

    /**
     * 写了递归
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        helper(chars, 0, k);
        return new String(chars);
    }

    private void helper(char[] chars, int index, int k) {
        if (index >= chars.length) {
            return;
        }
        for (int start = index, end = Math.min(index + k, chars.length) -1; start < end; start++, end--) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
        }
        helper(chars, index + 2 * k, k);
    }
}
