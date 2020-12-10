package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;

/**
 * Function: 选择排序
 *
 * @author zhangyu
 * Date: 2020/12/9
 * @since JDK 1.8
 */
public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = new int[]{3,52,12,46,43,6,8,90,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
            }
        }
    }
}
