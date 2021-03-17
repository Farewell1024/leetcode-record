package com.zhangyu.leetcoderecord.bytedance.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 3. 无重复字符的最长子串
 *
 * @author zhangyu
 * Date: 2021/3/17 11:13
 * @since JDK 1.8
 */
public class Solution0003 {

    public static void main(String[] args) {
        Solution0003 solution = new Solution0003();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }

    /**
     * 滑动窗口
     *
     * 找到以每个元素为基准的最长子串，比较其长度大小
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    max = Math.max(max, j - i);
                    break;
                } else {
                    max = Math.max(max, j - i + 1);
                    set.add(s.charAt(j));
                }
            }
            set.clear();
        }
        return max;
    }
}
