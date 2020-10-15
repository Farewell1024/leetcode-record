package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Function: 239. 滑动窗口最大值
 *
 * @author zhangyu
 * Date: 2020/10/15 16:02
 * @since JDK 1.8
 */
public class Solution0239 {

    public static void main(String[] args) {
        Solution0239 solution = new Solution0239();
        int[] result = solution.maxSlidingWindow(new int[]{41, 8467, 6334, 6500, 9169, 5724, 1478, 9358, 6962, 4464,
                5705, 8145, 3281}, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        int [] result = new int[nums.length -k + 1];
        ArrayDeque<Integer> window = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && i>=k && window.getFirst().equals(i-k)){
                window.removeFirst();
            }
            while (! window.isEmpty() && nums[window.getLast()] < nums[i]){
                window.removeLast();
            }
            window.addLast(i);
            if (i >= k-1){
                result[i-k+1] = nums[window.getFirst()];
            }
        }
        return result;
    }
}
