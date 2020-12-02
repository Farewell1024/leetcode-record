package com.zhangyu.leetcoderecord.problems;

import java.util.LinkedList;

/**
 * Function: 155. 最小栈
 *
 * @author zhangyu
 * Date: 2020/12/2 13:59
 * @since JDK 1.8
 */
public class Solution0155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        System.out.println("============================================================================================");
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());

    }

    /**
     * 官方解法  双栈
     */
    private static class MinStack {

        private LinkedList<Integer> valueStack , minStack;

        /** initialize your data structure here. */
        public MinStack() {
            valueStack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            valueStack.push(x);
            minStack.push(minStack.isEmpty()?x:Math.min(x, minStack.peek()));
        }

        public void pop() {
            valueStack.pop();
            minStack.pop();
        }

        public int top() {
            return valueStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 使用一个栈+数组
     */
    private static class MinStack2 {

        private LinkedList<int[]> valueStack;

        /** initialize your data structure here. */
        public MinStack2() {
            valueStack = new LinkedList<>();
        }

        public void push(int x) {
            valueStack.push(new int[]{x, valueStack.isEmpty()?x:Math.min(x, valueStack.peek()[1])});
        }

        public void pop() {
            valueStack.pop();
        }

        public int top() {
            return valueStack.peek()[0];
        }

        public int getMin() {
            return valueStack.peek()[1];
        }
    }
}
