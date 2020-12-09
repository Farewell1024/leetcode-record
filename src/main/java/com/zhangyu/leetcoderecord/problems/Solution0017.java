package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function: 17. 电话号码的字母组合
 *
 * @author zhangyu
 * Date: 2020/12/9 14:22
 * @since JDK 1.8
 */
public class Solution0017 {

    public static void main(String[] args) {
        Solution0017 solution = new Solution0017();
        System.out.println(solution.letterCombinations("23"));
    }

    /**
     * 字典
     */
    private Map<Character, char[]> dictionary = new HashMap<Character, char[]>(){
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    /**
     * main
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            helper(result, digits.length(), 0, new char[digits.length()], digits.toCharArray());
        }
        return result;
    }

    private void helper(List<String> result, int length, int index, char[] subResult, char[] chars) {
        if (index == length) {
            result.add(new String(subResult));
            return;
        }
        for (char c : dictionary.get(chars[index])) {
            subResult[index] = c;
            helper(result, length, index + 1, subResult, chars);
        }
    }


}
