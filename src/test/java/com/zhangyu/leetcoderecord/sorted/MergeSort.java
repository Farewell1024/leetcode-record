package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;

/**
 * Function: 归并排序
 *
 * @author zhangyu
 * Date: 2020/12/9
 * @since JDK 1.8
 */
public class MergeSort {

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
        int mid = start + (end - start) / 2;
        helper(arr, start, mid);
        helper(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int tmp [] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            tmp[k ++] = arr[i] > arr[j] ? arr[j ++] : arr[i ++];
        }
        while (i <= mid) {
            tmp[k ++] = arr[i ++];
        }
        while (j <= end) {
            tmp[k ++] = arr[j ++];
        }
        System.arraycopy(tmp, 0, arr, start, tmp.length);

    }
}
