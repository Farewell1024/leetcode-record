package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Function: 堆排序
 *
 * @author zhangyu
 * Date: 2020/12/10 09:55
 * @since JDK 1.8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 52, 12, 46, 43, 6, 8, 90, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 采用内置数据结构实现的
     */
    private static void testSort(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i --)
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right  = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }

    }

}