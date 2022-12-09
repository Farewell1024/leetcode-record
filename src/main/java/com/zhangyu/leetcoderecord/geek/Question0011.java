package com.zhangyu.leetcoderecord.geek;

/**
 * Function: Container With Most Water
 *
 * @author zhangyu
 * Date: 11/27/22
 * @since JDK 1.8
 */
public class Question0011 {

    public static void main(String[] args) {
        System.out.println(new Question0011().maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new Question0011().maxArea2(new int[]{1,1}));
    }

    /**
     * 暴力枚举
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }

    /**
     * 使用双指针代表左右边界
     * 向中心移动较低的那一边。
     * 因为如果移动较高的那一边，X轴的宽会越来越低，且高一定会小于等于当前较低的那边，面积一定是越来越小。
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            maxArea = Math.max(maxArea, (j - i) * (height[i] < height[j] ? height[i ++] : height[j --]));
        }
        return maxArea;
    }
}
