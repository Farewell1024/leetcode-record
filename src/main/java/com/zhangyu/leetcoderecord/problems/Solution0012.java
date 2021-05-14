package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 12. 整数转罗马数字
 *
 * @author zhangyu
 * Date: 2021/5/14
 * @since JDK 1.8
 */
public class Solution0012 {

    public static void main(String[] args) {
        Solution0012 solution = new Solution0012();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }

    /**
     * 模拟
     * 使用一个键值对从大到小去记录可能出现的值
     * 从左至右遍历数组，判断num和当前位的值对比，如果大于则num减去相应的数组值
     * 结果字符串append相应的罗马数字字符
     */
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num -= value[i];
                sb.append(symbol[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
    private static final int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * 硬编码
     *
     * 题目中num的取值范围为 1 - 3999
     * 所以可以列出每一位上所有的可能
     * 从高位开始分别判断每一位的值，组装成结果
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[num % 1000 / 100]);
        sb.append(tens[num % 100 / 10]);
        sb.append(units[num % 10]);
        return sb.toString();
    }
    private static final String[] thousands = {"","M","MM","MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
}
