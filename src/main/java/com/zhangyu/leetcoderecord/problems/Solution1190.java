package com.zhangyu.leetcoderecord.problems;

import java.util.LinkedList;

/**
 * Function: 1190. 反转每对括号间的子串
 *
 * @author zhangyu
 * Date: 2021/5/26
 * @since JDK 1.8
 */
public class Solution1190 {

    public static void main(String[] args) {
        Solution1190 solution = new Solution1190();
        System.out.println(solution.reverseParentheses("(abcd)"));
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    /**
     * 棧
     */
    public String reverseParentheses2(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 預處理括號
     */
    public String reverseParentheses(String s) {
        int[] brackets = new int[s.length()];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int j = stack.pop();
                brackets[i] = j;
                brackets[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0, step = 1; index < s.length(); index += step) {
            char c = s.charAt(index);
            if (c == '(' || c == ')') {
                index = brackets[index];
                step = -step;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
