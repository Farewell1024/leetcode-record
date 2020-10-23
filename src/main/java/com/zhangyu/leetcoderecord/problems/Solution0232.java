package com.zhangyu.leetcoderecord.problems;

import java.util.Stack;

/**
 * Function: 232. 用栈实现队列
 *
 * @author zhangyu
 * Date: 2020/10/23 15:16
 * @since JDK 1.8
 */
public class Solution0232 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }

    private static class MyQueue {

        private Stack<Integer> input;
        private Stack<Integer> output;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (output.isEmpty()) {
                resize();
            }
            return output.pop();
        }

        private void resize() {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (output.isEmpty()) {
                resize();
            }
            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

}
