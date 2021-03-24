package com.zhangyu.leetcoderecord.problems;


/**
 * Function: 415. 字符串相加
 *
 * @author zhangyu
 * Date: 2021/3/22 09:58
 * @since JDK 1.8
 */
public class Solution0415 {

    public static void main(String[] args) {
        Solution0415 solution = new Solution0415();
        System.out.println(solution.addStrings("123", "456"));
    }

    /**
     * 模拟竖式计算，从低位开始相加，存储进位 （官方解法）
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
             i >=0 || j >= 0 || carry > 0; i--, j--){
            int x = i < 0 ? 0 : (num1.charAt(i) - '0');
            int y = j < 0 ? 0 : (num2.charAt(j) - '0');
            int r = x + y + carry;
            sb.append(r % 10);
            carry = r / 10;
        }
        return sb.reverse().toString();
    }
}
