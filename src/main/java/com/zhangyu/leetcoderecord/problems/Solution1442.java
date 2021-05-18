package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 1442. 形成两个异或相等数组的三元组数目
 *
 * @author zhangyu
 * Date: 2021/5/18
 * @since JDK 1.8
 */
public class Solution1442 {

    public static void main(String[] args) {
        Solution1442 solution = new Solution1442();
        System.out.println(solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.countTriplets(new int[]{2, 3}));
        System.out.println(solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    /**
     * 题目关键是构建 异或前缀和
     */
    public int countTriplets(int[] arr) {
        int[] s = new int[arr.length + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = arr[i - 1] ^ s[i - 1];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int k = i + 1; k < arr.length; k ++) {
                if (s[i] == s[k + 1]) {
                    result += k - i;
                }
            }
        }
        return result;
    }

}
