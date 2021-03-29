package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;

/**
 * Function: 179. 最大数
 *
 * @author zhangyu
 * Date: 2021/3/29 10:20
 * @since JDK 1.8
 */
public class Solution0179 {

    public static void main(String[] args) {
        Solution0179 solution = new Solution0179();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution.largestNumber(new int[]{1}));
        System.out.println(solution.largestNumber(new int[]{10}));
        System.out.println(solution.largestNumber(new int[]{999999991,9}));
    }

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }
        Arrays.sort(strings, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        String result = String.join("", strings);
        return result.startsWith("0") ? "0" : result;
    }

    public String largestNumber2(int[] nums) {
        sort(nums, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }



    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int r = 0, i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            result[r++] = gt(nums[i], nums[j]) ? nums[i++] : nums[j++];
        }
        while (i <= mid) result[r++] = nums[i++];
        while (j <= end) result[r++] = nums[j++];
        System.arraycopy(result, 0, nums, start, result.length);
    }

    private boolean gt(int num, int num1) {
        return Long.parseLong(""+num+num1) > Long.parseLong(""+num1+num);
    }


}
