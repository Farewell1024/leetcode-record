package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 13. 罗马数字转整数
 *
 * @author zhangyu
 * Date: 2021/5/15
 * @since JDK 1.8
 */
public class Solution0013 {

    public static void main(String[] args) {
        Solution0013 solution = new Solution0013();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt("DCXXI"));
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = cache.get(s.charAt(i));
            if (i + 1 < s.length() && value < cache.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }
    private static final Map<Character, Integer> cache = new HashMap<Character, Integer>(){{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};

}
