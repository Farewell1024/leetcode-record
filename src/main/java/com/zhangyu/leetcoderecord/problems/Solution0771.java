package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 771. 宝石与石头
 *
 * @author zhangyu
 * Date: 2020/12/23 14:25
 * @since JDK 1.8
 */
public class Solution0771 {

    public static void main(String[] args) {
        Solution0771 solution = new Solution0771();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
        System.out.println((int)'A');
        System.out.println((int)'z');
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        int[]  cache = new int[58];
        for (int i = 0; i < stones.length(); i++) {
            cache[stones.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < jewels.length(); i++) {
            count += cache[jewels.charAt(i) - 'A'];
        }
        return count;
    }
}
