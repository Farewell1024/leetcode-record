package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Function: 1002. 查找常用字符
 *
 * @author zhangyu
 * Date: 2020/10/14 10:09
 * @since JDK 1.8
 */
public class Solution1002 {

    public static void main(String[] args) {
        Solution1002 solution = new Solution1002();
        System.out.println(solution.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(solution.commonChars(new String[]{"cool","lock","cook"}));
    }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;
        int[] minFlag = new int[26];
        Arrays.fill(minFlag, Integer.MAX_VALUE);
        for (String str : A) {
            int[] min = new int[26];
            for (char c : str.toCharArray()) {
                min[c-'a'] ++;
            }
            for (int i = 0; i < min.length; i++) {
                minFlag[i] = Integer.min(minFlag[i], min[i]);
            }
        }
        for (int i = 0; i < minFlag.length; i++) {
            int finalI = i;
            IntStream.range(0, minFlag[i]).forEach(a -> result.add(Character.toString((char) ('a'+ finalI))));
        }
        return result;
    }

    /**
     * 网友创作，省掉了一份空间
     */
    public List<String> commonChars2(String[] A) {
        int[] acs = getCs(A[0]);
        for (int i = 1; i < A.length; i++) {
            int[] aics = getCs(A[i]);
            for (int j = 0; j < acs.length; j++) {
                if (acs[j] > aics[j]) {
                    acs[j] = aics[j];
                }
            }
        }

        List<String> list = new LinkedList<>();
        for (int i = 0; i < acs.length; i++) {
            String e = Character.toString((char) ('a' + i));
            while (acs[i]-- > 0) {
                list.add(e);
            }
        }
        return list;
    }

    private int[] getCs(String s) {
        int[] cs = new int[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        return cs;
    }

}
