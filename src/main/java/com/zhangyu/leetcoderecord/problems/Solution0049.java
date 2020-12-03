package com.zhangyu.leetcoderecord.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Function: 49. 字母异位词分组
 *
 * @author zhangyu
 * Date: 2020/12/3 10:20
 * @since JDK 1.8
 */
public class Solution0049 {

    public static void main(String[] args) {
        Solution0049 solution = new Solution0049();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 解法1  将数组中的每个字符串进行排序，排序后一样的字符串即为异位词。使用分组，即为结果。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = Stream.of(strs).collect(Collectors.groupingBy(x -> {
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
        return new ArrayList<>(map.values());
    }

    /**
     * 统计每个字符串的数量，分组
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] cache = new int[26];
        Map<String, List<String>> collect = Stream.of(strs).collect(Collectors.groupingBy(x -> {
            Arrays.fill(cache, 0);
            for (char c : x.toCharArray()) {
                cache[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cache.length; i++) {
                sb.append("_");
                sb.append(cache[i]);
            }
            return sb.toString();
        }));
        return new ArrayList<>(collect.values());
    }
}
