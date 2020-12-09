package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 22. 括号生成
 *
 * @author zhangyu
 * Date: 2020/10/21 14:32
 * @since JDK 1.8
 */
public class Solution0022 {

    public static void main(String[] args) {
        Solution0022 solution = new Solution0022();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        if (n==0) return null;
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    public void generateParenthesis (List<String> result, String subResult, int left, int right){
        if (left == 0 && right==0){
            result.add(subResult);
            return;
        }
        if (left > 0) {
            generateParenthesis(result, subResult + "(", left-1, right);
        }
        if (right > left) {
            generateParenthesis(result, subResult+")", left, right-1);
        }
    }
}
