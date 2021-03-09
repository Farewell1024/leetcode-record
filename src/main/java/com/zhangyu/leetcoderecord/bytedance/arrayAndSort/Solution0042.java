package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

/**
 * Function: 42. 接雨水
 * TODO 学习官方题解剩下两种解法
 * @author zhangyu
 * Date: 2021/3/8 09:48
 * @since JDK 1.8
 */
public class Solution0042 {

    public static void main(String[] args) {
        Solution0042 solution = new Solution0042();
        System.out.println(solution.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap2(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(solution.trap2(new int[]{4, 2, 3}));
    }

    /**
     * 官方解法1：暴力法
     * <p>
     * 遍历数组中的每一个元素，找到以次元素为基准的左右两边最高的元素值
     * 其较小者减去此元素的值即为当前位置上能存放的雨水量
     * 加入到结果
     */
    public int trap(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    /**
     * 官方解法2：动态规划
     */
    public int trap2(int[] height) {
        if (height.length == 0) return 0;
        int result = 0;
        int[] maxLeft = new int[height.length], maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        maxRight[maxRight.length - 1] = height[height.length - 1];
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }


//    public int trap(int[] height) {
//        int result = 0;
//        for (int i = 0; i < height.length; ) {
//            if (height[i] == 0) {
//                i ++;
//                continue;
//            }
//            int between = 0, j = i + 1;
//            for (; j < height.length; j++) {
//                if (height[j] >= height[i]) {
//                    break;
//                }
//                between += height[j];
//            }
//            if (j == height.length || j == i + 1) {
//                i = i + 1;
//            } else {
//                result += ((j - i - 1) * height[i] - between);
//                i = j;
//            }
//        }
//        return result;
//    }

}
