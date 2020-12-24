package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 58. 最后一个单词的长度
 *
 * 本题的解法思想是，从后往前遍历，遇到遇到空格则停止
 *
 * @author zhangyu
 * Date: 2020/12/23 13:01
 * @since JDK 1.8
 */
public class Solution0058 {

    public static void main(String[] args) {
        Solution0058 solution = new Solution0058();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord(""));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord("a"));
        System.out.println(solution.lengthOfLastWord(" a"));
        System.out.println(solution.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count ++ ;
        }
        return count;
    }

    public int lengthOfLastWord2(String s) {
        int blank = 0;
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i + 1;
                break;
            }
        }
        for (int index = end - 1; index >= 0; index--) {
            if (s.charAt(index) == ' ') {
                blank = index + 1;
                break;
            }
        }
        return end - blank;
    }
}
