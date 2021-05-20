package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 692. 前K个高频单词
 *
 * @author zhangyu
 * Date: 2021/5/20
 * @since JDK 1.8
 */
public class Solution0692 {

    public static void main(String[] args) {
        Solution0692 solution = new Solution0692();
        System.out.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(countMap.keySet());
        list.sort((o1, o2) -> countMap.get(o1).equals(countMap.get(o2)) ? o1.compareTo(o2) : countMap.get(o2) - countMap.get(o1));
        return list.subList(0, k);
    }
}
