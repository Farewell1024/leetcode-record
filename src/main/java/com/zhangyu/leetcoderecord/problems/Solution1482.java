package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 1482. 制作 m 束花所需的最少天数
 *
 * @author zhangyu
 * Date: 2021/5/9
 * @since JDK 1.8
 */
public class Solution1482 {

    public static void main(String[] args) {
        Solution1482 solution = new Solution1482();
        System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(solution.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(solution.minDays(new int[]{1000000000, 1000000000}, 1, 1));
        System.out.println(solution.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }

    /**
     * 二分查找
     * 1. m*k小于数组长度，直接返回
     * 2. 采用二分查找，采用helper函数判断每一天是否能制作出满足条件的花束
     * 3. helper函数中，拿到数组中的每一个小于等于day的元素，判断连续k朵的花束数量，是否大于等于需求的m束花
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 如果m*k小于数组长度，则证明一定不能制作m束花
        if (m > bloomDay.length / k) {
            return -1;
        }
        // 确认循环次数
        int low = Integer.MAX_VALUE, high = 0;
        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (helper(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean helper(int[] bloomDay, int mid, int m, int k) {
        // 定义"束"，和每束的花多数
        int bunch = 0, flower = 0;
        // 判断条件是hi：遍历一次数组，并且能制作的束数小于需求的束数
        for (int i = 0; i < bloomDay.length && bunch < m; i++) {
            if (mid >= bloomDay[i]) {
                flower++;
                // 如果本束的花多数等于要求的花多数，就能制作出新的一束花，花多数还原
                if (flower == k) {
                    bunch++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return bunch >= m;
    }
}
