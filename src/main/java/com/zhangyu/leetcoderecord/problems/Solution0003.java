package com.zhangyu.leetcoderecord.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 3. 无重复字符的最长子串
 *
 * @author zhangyu
 * Date: 2020/10/21 14:08
 * @since JDK 1.8
 */
public class Solution0003 {

    public static void main(String[] args) {
        Solution0003 solution = new Solution0003();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (characters.contains(s.charAt(j))) {
                    max = Math.max(max, j-i);
                    break;
                } else {
                    max = Math.max(max, j-i + 1);
                    characters.add(s.charAt(j));
                }
            }
            characters.clear();
        }
        return max;
    }
}
