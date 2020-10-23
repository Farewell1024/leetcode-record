package com.zhangyu.leetcoderecord.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Function: 225. 用队列实现栈
 *
 * @author zhangyu
 * Date: 2020/10/23 12:15
 * @since JDK 1.8
 */
public class Solution0225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    private static class MyStack {

        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            int count = 0;
            while (count < queue.size() - 1) {
                queue.add(queue.remove());
                count++;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }


}
