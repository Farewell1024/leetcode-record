package com.zhangyu.leetcoderecord.problems.unfinished;

import java.util.Arrays;

/**
 * Function: 274. H 指数
 *
 * @author zhangyu
 * Date: 7/12/21
 * @since JDK 1.8
 */
public class Solution0274 {

    public static void main(String[] args) {
        Solution0274 solution = new Solution0274();
        System.out.println(solution.hIndex(new int[]{3,0,6,1,5}));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0 && citations[i] > h; i--) {
            h ++;
        }
        return h;
    }
}
