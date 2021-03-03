package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Function: 128. 最长连续序列
 *
 * @author zhangyu
 * Date: 2021/3/3 15:35
 * @since JDK 1.8
 */
public class Solution0128 {

    public static void main(String[] args) {
        Solution0128 solution = new Solution0128();
        System.out.println(solution.longestConsecutive2(new int[]{100,4,200,1,3,2}));
        System.out.println(solution.longestConsecutive2(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive2(new int[]{1,2,3,5,6,7,8,9}));
        System.out.println(solution.longestConsecutive2(new int[]{1,2,0,1}));
    }

    /**
     * 排序 再遍历
     *
     * 但是这样做不符合题目要求的 O(n) 的时间复杂度 排序本身就是 O(nlogn) 的
     * 遍历是 O(n)
     * 总体的时间复杂度还是 O(nlogn)
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了92.11%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了33.72%的用户
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                pre ++;
                continue;
            }
            if (nums[i] != nums[i - 1] + 1) {
                pre = i;
                continue;
            }
            max = Math.max(max, i + 1 - pre);
        }
        return max;
    }

    /**
     * 官方解法 哈希表
     *
     * 执行用时：5 ms, 在所有 Java 提交中击败了82.97%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了89.63%的用户
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            // 因为 1,2,3 排序得出的结果必定大于 2,3
            // 所以如果这个数的前一个数，不在数组中，用来进行查找得到的值，即为最大值
            if (! set.contains(num - 1)) {
                int tmp = num, count = 1;
                while (set.contains(++tmp)) {
                    count ++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

}
