package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 8. 字符串转换整数 (atoi)
 *
 * 官方题解有一种叫"状态机"的东西  不知道是什么玩意儿
 *
 * @author zhangyu
 * Date: 2020/12/23
 * @since JDK 1.8
 */
public class Solution0008 {

    public static void main(String[] args) {
        Solution0008 solution = new Solution0008();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("419xxx"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("2147483646"));
    }

    public int myAtoi(String s) {
        int sign = 1, result = 0, index = 0, end = s.length() - 1;
        // remove blank
        while (index <= end && s.charAt(index) == ' ') {
            index ++;
        }
        if (index > end) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(index)) && s.charAt(index) != '-' && s.charAt(index) != '+') {
            return 0;
        }
        if (!Character.isDigit(s.charAt(index))) {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index ++;
        }
        while (index <= end && Character.isDigit(s.charAt(index))) {
            int num = s.charAt(index ++) - '0';
            if (result > (Integer.MAX_VALUE - num) / 10 ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + num;
        }
        return sign * result;
    }

}
