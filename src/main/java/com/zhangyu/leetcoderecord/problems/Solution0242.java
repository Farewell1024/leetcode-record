package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: 242. 有效的字母异位词
 *
 * @author zhangyu
 * Date: 2020/10/15 16:05
 * @since JDK 1.8
 */
public class Solution0242 {

    public static void main(String[] args) {
        Solution0242 solution = new Solution0242();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));

        System.out.println(solution.isAnagram2("anagram", "nagaram"));
        System.out.println(solution.isAnagram2("rat", "car"));
    }

    /**
     * 双Map解法
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length()!=t.length()){
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (sMap.containsKey(c)){
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (! sMap.containsKey(c)){
                return false;
            }
            if (tMap.containsKey(c)){
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Character character : sMap.keySet()) {
            if (! sMap.get(character).equals( tMap.get(character))){
                return false;
            }
        }
        return true;
    }

    /**
     * 数组计数解法
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length()!=t.length()){
            return false;
        }
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (char c : s.toCharArray()) {
            sArray[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            tArray[c - 'a'] += 1;
        }
        return Arrays.equals(sArray, tArray);
    }

}
