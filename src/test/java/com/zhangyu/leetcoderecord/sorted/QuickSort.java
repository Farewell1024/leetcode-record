package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;

/**
 * Function: 快排
 *
 * @author zhangyu
 * Date: 2020/12/9
 * @since JDK 1.8
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] arr = new int[]{3,52,12,46,43,6,8,90,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int [] arr) {
        helper(arr, 0, arr.length - 1);
    }

    private static void helper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int counter = start;
        for (int i = counter; i < end; i++) {
            if (arr[i] < arr[end]) {
                int tmp = arr[i];
                arr[i] = arr[counter];
                arr[counter ++] = tmp;
            }
        }
        int tmp = arr[end];
        arr[end] = arr[counter];
        arr[counter] = tmp;
        helper(arr, start, counter - 1);
        helper(arr, counter + 1, end);
    }
}
