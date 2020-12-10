package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;

/**
 * Function: 插入排序
 *
 * @author zhangyu
 * Date: 2020/12/9
 * @since JDK 1.8
 */
public class InsertionSort {

    public static void main(String[] args) {
        int [] arr = new int[]{3,52,12,46,43,6,8,90,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] >= arr[j]) {
                    continue;
                }
                arr[j + 1] += arr[j];
                arr[j] = arr[j + 1] - arr[j];
                arr[j+1] -= arr[j];
            }
        }
    }
}
