package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Function: 347. 前 K 个高频元素
 *
 * @author zhangyu
 * Date: 2020/10/23 16:52
 * @since JDK 1.8
 */
public class Solution0347 {

    public static void main(String[] args) {
        Solution0347 solution = new Solution0347();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getValue(), entry.getKey()});
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove()[1];
        }
        return result;
    }
}
