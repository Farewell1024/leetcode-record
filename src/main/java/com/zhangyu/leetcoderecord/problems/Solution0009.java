package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 9. 回文数
 *
 * @author zhangyu
 * Date: 2020/10/21 14:16
 * @since JDK 1.8
 */
public class Solution0009 {

    public static void main(String[] args) {
        Solution0009 solution = new Solution0009();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        for (int left=0, right=s.length()-1;left<right; left++, right--){
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}
