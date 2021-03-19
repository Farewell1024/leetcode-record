package com.zhangyu.leetcoderecord.bytedance.strings;

import java.util.Arrays;

/**
 * Function: 14. 最长公共前缀
 *
 * @author zhangyu
 * Date: 2021/3/19 09:54
 * @since JDK 1.8
 */
public class Solution0014 {

    public static void main(String[] args) {
        Solution0014 solution = new Solution0014();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    /**
     * 纵向查询
     *
     * 以列表中的第一个元素为基准，遍历其每一个char，判断其余字符串中是否有不一样的
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向查询
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < result.length()) {
                result = result.substring(0, strs[i].length());
            }
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 二分
     * TODO 强行二分 待实现
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int start = 0, end = Integer.MAX_VALUE;
        for (String str : strs) {
            end = Math.min(end, str.length());
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            char c = strs[0].charAt(mid);
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(mid) != c){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return strs[0].substring(0, start);
    }

    /**
     * 排序后比较第一个和最后一个的公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1;
    }

}
