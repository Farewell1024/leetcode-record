package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 125. 验证回文串
 *
 * @author zhangyu
 * Date: 2020/11/2 13:39
 * @since JDK 1.8
 */
public class Solution0125 {

    public static void main(String[] args) {
        Solution0125 solution = new Solution0125();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(""));
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (! checkValid(s.charAt(start))){
                start ++;
            } else if (! checkValid(s.charAt(end))) {
                end --;
            } else {
                if (s.charAt(start ++) != s.charAt(end --)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
