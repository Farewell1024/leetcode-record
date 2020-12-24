package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 557. 反转字符串中的单词 III
 *
 * @author zhangyu
 * Date: 2020/12/24 10:56
 * @since JDK 1.8
 */
public class Solution0557 {

    public static void main(String[] args) {
        Solution0557 solution = new Solution0557();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        // reverse every words
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                int start = i;
                while (i < charArray.length && charArray[i] != ' ') {
                    i ++;
                }
                reverse(charArray, start, i - 1);
            }
        }
        return new String(charArray);
    }

    private void reverse(char[] charArray, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
        }
    }
}
