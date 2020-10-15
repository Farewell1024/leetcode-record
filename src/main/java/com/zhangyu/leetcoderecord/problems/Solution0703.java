package com.zhangyu.leetcoderecord.problems;

import java.util.PriorityQueue;

/**
 * Function: 703. 数据流中的第K大元素
 *
 * @author zhangyu
 * Date: 2020/10/15 14:48
 * @since JDK 1.8
 */
public class Solution0703 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        // return 4
        System.out.println(kthLargest.add(3));
        // return 5
        System.out.println(kthLargest.add(5));
        // return 5
        System.out.println(kthLargest.add(10));
        // return 8
        System.out.println(kthLargest.add(9));
        // return 8
        System.out.println(kthLargest.add(4));

    }

    static class KthLargest {

        // 小顶堆
        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else {
                if (val > queue.peek()) {
                    queue.remove();
                    queue.add(val);
                }
            }
            return queue.peek();
        }
    }
}
