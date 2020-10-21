package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Function: 20. 有效的括号
 *
 * @author zhangyu
 * Date: 2020/10/21 14:20
 * @since JDK 1.8
 */
public class Solution0020 {

    public static void main(String[] args) {
        Solution0020 solution = new Solution0020();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> paramMap = new HashMap<Character, Character>(3){
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && paramMap.containsKey(c)) {
                return false;
            }
            if (paramMap.containsValue(c)){
                stack.push(c);
            }
            if (paramMap.containsKey(c) && !paramMap.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
