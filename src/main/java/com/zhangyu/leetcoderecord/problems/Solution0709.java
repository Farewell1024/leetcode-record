package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 709. 转换成小写字母
 *
 * @author zhangyu
 * Date: 2020/12/23 11:54
 * @since JDK 1.8
 */
public class Solution0709 {

    public static void main(String[] args) {
        Solution0709 solution = new Solution0709();
        System.out.println(solution.toLowerCase("Hello"));
        System.out.println(solution.toLowerCase("here"));
        System.out.println(solution.toLowerCase("LOVELY"));
//        System.out.println('A' - 'a');
    }

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c + 32);
            }
        }
        return new String(chars);
    }
}
