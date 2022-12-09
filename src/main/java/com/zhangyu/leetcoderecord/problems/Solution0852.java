package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 852. 山脉数组的峰顶索引
 *
 * @author zhangyu
 * Date: 6/15/21
 * @since JDK 1.8
 */
public class Solution0852 {

    public static void main(String[] args) {
        Solution0852 solution = new Solution0852();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 1, end = arr.length - 2;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
