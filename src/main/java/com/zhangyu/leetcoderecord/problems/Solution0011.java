package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 11. 盛最多水的容器
 *
 * @author zhangyu
 * Date: 2020/12/1 10:16
 * @since JDK 1.8
 */
public class Solution0011 {

    public static void main(String[] args) {
        Solution0011 solution = new Solution0011();
        System.out.println(solution.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(solution.maxArea2(new int[]{1,1}));
        System.out.println(solution.maxArea2(new int[]{4,3,2,1,4}));
        System.out.println(solution.maxArea2(new int[]{1,2,1}));
    }

    /**
     * 枚举
     * n 平方
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[j], height[i]));
            }
        }
        return max;
    }

    /**
     * 双指针向中间收敛  保证宽度的情况下，选择相对高的边
     * 时间复杂度 n
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int left = 0, right = height.length - 1; left < right;) {
            max = Math.max(max, (height[left] < height[right] ? height[left ++] : height[right --]) * (right - left + 1));
        }
        return max;
    }


}
