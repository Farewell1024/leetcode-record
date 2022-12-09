package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 67. Add Binary
 *
 * @author zhangyu
 * Date: 7/13/21
 * @since JDK 1.8
 */
public class Solution0067 {

    public static void main(String[] args) {
        Solution0067 solution = new Solution0067();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("0", "0"));
    }

    /**
     * 模拟
     * 从低位开始相加，carry表示进位
     */
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        char[] result = new char[n];
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += a.length() <= i ? 0 : a.charAt(a.length() - 1 - i) - '0';
            carry += b.length() <= i ? 0 : b.charAt(b.length() - 1 - i) - '0';
            result[n - i - 1] = (char)(carry % 2 + '0');
            carry /= 2;
        }
        return (carry == 1 ? "1" : "") + new String(result);
    }
}
