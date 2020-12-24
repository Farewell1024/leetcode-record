package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 387. 字符串中的第一个唯一字符
 *
 * @author zhangyu
 * Date: 2020/12/23 15:36
 * @since JDK 1.8
 */
public class Solution0387 {

    public static void main(String[] args) {
        Solution0387 solution = new Solution0387();
        long l = System.nanoTime();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(System.nanoTime() - l);

        l = System.nanoTime();
        System.out.println(solution.firstUniqChar2("leetcode"));
        System.out.println(solution.firstUniqChar2("loveleetcode"));
        System.out.println(System.nanoTime() - l);
    }

    /**
     * 计数
     */
    public int firstUniqChar(String s) {
        int[] cache = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        int result = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                result = Math.min(result, entry.getValue());
            }
        }
        return result == s.length() ? -1 : result;
    }


}
