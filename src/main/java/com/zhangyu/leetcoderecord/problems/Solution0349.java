package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Function: 349. 两个数组的交集
 *
 * @author zhangyu
 * Date: 2020/11/2 09:25
 * @since JDK 1.8
 */
public class Solution0349 {

    public static void main(String[] args) {
        Solution0349 solution = new Solution0349();
        System.out.println(Arrays.toString(solution.intersection2(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(solution.intersection2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(solution.intersection2(new int[]{}, new int[]{})));
    }

    /**
     * 两个Set的一种Java8 Stream 解法
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> dictionary = new HashSet<>();
        IntStream.of(nums1).forEach(dictionary::add);
        IntStream.of(nums2).filter(dictionary::contains).forEach(result::add);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 官方解法2 -- 双指针
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0, index1 = 0, index2 = 0;
        int [] interaction = new int[Math.max(nums1.length, nums2.length)];
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 || interaction[index - 1] != nums1[index1]) {
                    interaction[index ++] = nums1[index1];
                }
                index1 ++;
                index2 ++;
            } else if (nums1[index1] < nums2[index2]){
                index1 ++;
            } else {
                index2 ++;
            }
        }
        return Arrays.copyOf(interaction, index) ;
    }


}
