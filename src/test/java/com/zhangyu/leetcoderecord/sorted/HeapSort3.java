package com.zhangyu.leetcoderecord.sorted;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2021/3/3
 * @since JDK 1.8
 */
public class HeapSort3 {

    public static void main(String[] args) {
//        HeapSort3 heapSort = new HeapSort3();
//        int[] arr = {7,1,3,10,5,2,8,9,6};
//        heapSort.sortWithPriorityQueue(arr);
//        System.out.println(Arrays.toString(arr));

        System.out.println("".getBytes().length);
    }

    /**
     * java api 堆排序
     */
    public void sortWithPriorityQueue(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int i : arr) {
            queue.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }

    /**
     * 手动维护的堆排序
     */
    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

    }

    private void heapify(int[] arr, int length, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < length && arr[max] < arr[left]) {
            max = left;
        }
        if (right < length && arr[max] < arr[right]) {
            max = right;
        }
        if (max != index) {
            swap(arr, max, index);
            heapify(arr, length, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
