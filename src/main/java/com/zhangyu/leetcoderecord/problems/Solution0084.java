package com.zhangyu.leetcoderecord.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Function: 84. 柱状图中最大的矩形
 *
 * @author zhangyu
 * Date: 2020/12/2 14:43
 * @since JDK 1.8
 */
public class Solution0084 {

    public static void main(String[] args) {
        Solution0084 solution = new Solution0084();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(solution.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
        System.out.println(solution.largestRectangleArea2(new int[]{1, 1}));
        System.out.println(solution.largestRectangleArea2(new int[]{2, 3}));
    }

    /**
     * 暴力
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j - i + 1) * min);
            }
        }
        return max;
    }

    /**
     * 使用栈
     */
    public int largestRectangleArea2(int[] heights) {
        // result
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 辅助数
        stack.add(-1);
        for (int i = 0; i < heights.length; i++) {
            // 当插入的对象比栈顶的对象小时候 说明栈顶元素找到了右边界 就可以出栈计算面积了
            while (stack.peek() != -1 && heights[i] <heights[stack.peek()]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 遍历完成之后，还会有元素留在栈中，这是弹出剩余所有元素，计算面积
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return max;
    }

}
