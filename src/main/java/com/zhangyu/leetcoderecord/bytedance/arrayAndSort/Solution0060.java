package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 60. 排列序列
 *
 * @author zhangyu
 * Date: 2021/3/3 17:57
 * @since JDK 1.8
 */
public class Solution0060 {

    public static void main(String[] args) {
        Solution0060 solution = new Solution0060();
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
        System.out.println(solution.getPermutation(3, 1));
    }

    /**
     * 枚举所有结果 （超出时间限制）
     */
    public String getPermutation(int n, int k) {
        List<String> stringList = new ArrayList<>();
        helper(new boolean[n], "", stringList);
        System.out.println(stringList);
        return stringList.get(k - 1);
    }

    private void helper(boolean[] flag, String result, List<String> stringList) {
        if (result.length() == flag.length) {
            stringList.add(result);
            return;
        }
        for (int i = 0; i < flag.length; i++) {
            if (! flag[i]) {
                flag[i] = true;
                helper(flag, result + (i + 1), stringList);
                flag[i] = false;
            }
        }
    }
}
