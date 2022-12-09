package com.zhangyu.leetcoderecord.xiaohao;

import java.util.Arrays;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2/22/22
 * @since JDK 1.8
 */
public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < Math.min(temp.length(), strs[i].length()); j ++) {
                if (temp.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return "";
            }
            temp = temp.substring(0, j);
        }
        return temp;
    }

    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        for (; index < Math.min(first.length(), last.length()); index ++) {
            if (first.charAt(index) != last.charAt(index)) {
                break;
            }
        }
        return first.substring(0, index);
    }
}
