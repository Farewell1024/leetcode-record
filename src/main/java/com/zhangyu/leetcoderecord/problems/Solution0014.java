package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 14. 最长公共前缀
 *
 * Tag ： ByteDance
 *
 * @author zhangyu
 * Date: 2020/11/5 09:43
 * @since JDK 1.8
 */
public class Solution0014 {

    public static void main(String[] args) {
        Solution0014 solution = new Solution0014();
        System.out.println(solution.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));

    }

    /**
     * 自己解法。 31.47% ： 95.73%
     * 官方解法1
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs ==null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (;j < Math.min(strs[i].length(), prefix.length()); j++){
                if (prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            prefix = prefix.substring(0, j);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 解法2 ：来自评论区网友
     * 思想是：先进行排序，排序后只需要比较第一个字符串和最后一个字符串的公共子序列即可
     * 很灵活的思维方式
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        for (;i < Math.min(start.length(), end.length()); i++){
            if (start.charAt(i) != end.charAt(i)) {
                break;
            }
        }
        return start.substring(0, i);
    }

}
