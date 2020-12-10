package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;

/**
 * Function: 堆排序
 *
 * @author zhangyu
 * Date: 2020/12/10
 * @since JDK 1.8
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 52, 12, 46, 43, 6, 8, 90, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int [] arr) {
        if (arr.length == 0) {
            return;
        }
        /*
                       3
                 52         12
             46     43   6      8
          90    7
         */
        int n = arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, n , i);
        }
        for (int i = n; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        int child1 = 2 * i + 1;
        int child2 = 2 * i + 2;
        int max = i;
        if (child1 < length && arr[child1] > arr[max]) {
            max = child1;
        }
        if (child2 < length && arr[child2] > arr[max]) {
            max = child2;
        }
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, length, max);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
