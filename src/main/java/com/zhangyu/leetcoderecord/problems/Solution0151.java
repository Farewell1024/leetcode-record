package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 151. 翻转字符串里的单词
 *
 * @author zhangyu
 * Date: 2020/12/24 10:24
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
        // reverse all
        reverse(charArray, 0, charArray.length - 1);
        // remove blanks
        int position = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ' && (position == 0 || charArray[position - 1] == ' ')) {
                continue;
            }
            charArray[position++] = charArray[i];
        }
        // remove last blank if exist
        if (charArray[position - 1] == ' ') {
            position --;
        }
        return new String(charArray, 0, position);
    }

    private void reverse(char[] charArray, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
        }
    }


}
