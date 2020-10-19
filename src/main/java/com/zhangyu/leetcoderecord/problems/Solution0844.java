package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 844. 比较含退格的字符串
 *
 * @author zhangyu
 * Date: 2020/10/19 10:16
 * @since JDK 1.8
 */
public class Solution0844 {

    public static void main(String[] args) {
        Solution0844 solution = new Solution0844();
        System.out.println(solution.backspaceCompare2("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare2("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare2("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare2("a#c", "b"));
        System.out.println(solution.backspaceCompare2("y#fo##f", "y#f#o##f"));
        System.out.println(solution.backspaceCompare2("", ""));
        System.out.println(solution.backspaceCompare2("nzp#o#g", "b#nzp#o#g"));
    }

    /**
     * 类似栈的方法
     */
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    public String helper (String str) {
        StringBuilder builder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (c == '#' ) {
                if (builder.length()>0){
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 指针。
     * 从后向前遍历，'#'的下一个字符必定是被消除的
     */
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i>=0) {
                if (S.charAt(i) == '#') {
                    skipS ++;
                    i --;
                } else if (skipS > 0) {
                    skipS --;
                    i --;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT ++;
                    j --;
                } else if (skipT > 0) {
                    skipT --;
                    j --;
                }else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i --;
            j --;
        }
        System.out.println(i);
        System.out.println(j);
        return i == j;
    }

}
