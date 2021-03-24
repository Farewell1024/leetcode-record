package com.zhangyu.leetcoderecord.bytedance.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Function: 151. 翻转字符串里的单词
 *
 * @author zhangyu
 * Date: 2021/3/23 09:35
 * @since JDK 1.8
 */
public class Solution0151 {

    public static void main(String[] args) {
        Solution0151 solution = new Solution0151();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(solution.reverseWords("Alice does not even like bob"));
    }

    public String reverseWords(String s) {
        List<String> strings = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

}
