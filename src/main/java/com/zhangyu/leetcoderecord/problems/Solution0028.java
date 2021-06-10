package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 28. 实现 strStr()
 *
 * @author zhangyu
 * Date: 6/8/21
 * @since JDK 1.8
 */
public class Solution0028 {

    public static void main(String[] args) {
        Solution0028 solution = new Solution0028();
//        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("lello", "ll"));
//        System.out.println(solution.strStr("aaaaa", "bba"));
//        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int i = 0, j = 0;
        for (; i < haystack.length() && j < needle.length(); i ++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j ++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }
}
