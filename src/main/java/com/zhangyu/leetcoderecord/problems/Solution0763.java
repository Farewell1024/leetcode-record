package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 763. 划分字母区间
 *
 * @author zhangyu
 * Date: 2020/10/22 09:36
 * @since JDK 1.8
 */
public class Solution0763 {

    public static void main(String[] args) {
        Solution0763 solution = new Solution0763();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(solution.partitionLabels2("ababcbacadefegdehijhklij"));
    }

    /**
     * 自己的写法
     */
    public List<Integer> partitionLabels(String S) {
        int[] flag = new int[26];
        for (char c : S.toCharArray()) {
            flag[c-'a'] ++;
        }
        List<Integer> result = new ArrayList<>();
        int pre = 0;
        List<Character> cache = new ArrayList<>();
        for (int i = 1; i <= S.length(); i++) {
            cache.add(S.charAt(i-1));
            flag[S.charAt(i-1)-'a'] --;
            if (cache.stream().allMatch(x -> flag[x-'a']==0)){
                cache.clear();
                result.add(i - pre);
                pre = i;
            }
        }
        return result;
    }

    /**
     * 官方解法
     */
    public List<Integer> partitionLabels2(String S) {
        // 获得每个字母最后一次出现的下标
        int[] flag = new int[26];
        for (int i = 0; i < S.length(); i++) {
            flag[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        // 双指针
        int end = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, flag[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

}
