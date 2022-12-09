package com.zhangyu.leetcoderecord.xiaohao;

import java.util.*;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2/21/22
 * @since JDK 1.8
 */
public class Solution350 {

    public static void main(String[] args) {
        Solution350 solution = new Solution350();
        System.out.println(Arrays.toString(solution.intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                nums2[count++] = num;
                map.put(num, map.getOrDefault(num, 0) - 1);
            }
        }
        return Arrays.copyOfRange(nums2, 0, count);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length];
        int index = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                result[index++] = nums1[i++];
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

}
