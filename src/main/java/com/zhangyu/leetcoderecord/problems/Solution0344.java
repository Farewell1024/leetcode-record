package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 344. 反转字符串
 *
 * @author zhangyu
 * Date: 2020/12/23
 * @since JDK 1.8
 */
public class Solution0344 {

    public static void main(String[] args) {
        Solution0344 solution = new Solution0344();

        char[] chars = {'h','e','l','l','o'};
        solution.reverseString(chars);
        System.out.println(Arrays.toString(chars));

        chars = new char[]{'H','a','n','n','a','h'};
        solution.reverseString(chars);
        System.out.println(Arrays.toString(chars));

    }

    public void reverseString(char[] s) {
        for (int i = 0, end = s.length - 1; i < end; i++, end --) {
            char tmp = s[i];
            s[i] = s[end];
            s[end] = tmp;
        }
    }
}
