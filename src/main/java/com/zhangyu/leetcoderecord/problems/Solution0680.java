package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 680. 验证回文字符串 Ⅱ
 *
 * @author zhangyu
 * Date: 2020/12/24 11:46
 * @since JDK 1.8
 */
public class Solution0680 {

    public static void main(String[] args) {
        Solution0680 solution = new Solution0680();
        long nanoTime = System.nanoTime();
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abzbzbca"));
        System.out.println(solution.validPalindrome("abzbzbca"));
        System.out.println(solution.validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(System.nanoTime() - nanoTime);
    }

    /**
     * 双指针，从头尾开始。遇到有字符不一样的时候，分别跳过左右两个进行验证
     */
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int start = 0, end = s.length() - 1; start < end; start ++, end --) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
        }
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        for (; start < end; start ++, end --) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

}
