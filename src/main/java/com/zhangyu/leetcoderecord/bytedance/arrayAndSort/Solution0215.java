package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

import java.util.Arrays;

/**
 * Function: 215. 数组中的第K个最大元素
 *
 * @author zhangyu
 * Date: 2021/3/2 16:16
 * @since JDK 1.8
 */
public class Solution0215 {

    public static void main(String[] args) {
        Solution0215 solution = new Solution0215();
//        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
//        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        int[] arr = {3, 2, 1, 5, 6, 4};
//        solution.insertionSort(arr);
        solution.countingSort(arr, 6);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序后 找到"length-k"下标所对应的值，即为结果
     * <p>
     * 采用jdk自带数组排序
     * 执行用时：2 ms, 在所有 Java 提交中击败了90.28%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了98.81%的用户
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

// ================ 依据此题 复习排序算法 ============

    /**
     * 交换数组中指定下标的两个元素
     *
     * @param nums   数组
     * @param first  第一个下标
     * @param second 第二个下标
     */
    public void swap(int[] nums, int first, int second) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j + 1] > nums[j]) {
                    break;
                }
                swap(nums, j, j+1);
            }
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] nums) {
        class MergeSortHelper {
            public void sort(int[] nums) {

            }


        }
        MergeSortHelper mergeSortHelper = new MergeSortHelper();
        mergeSortHelper.sort(nums);
    }

    /**
     * 记数排序
     * 需知道最大值，不适用于此题
     */
    public void countingSort(int[] nums, int max) {
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] ++;
        }
        for (int i = 0, j = 0; j < count.length; j++) {
            while (count[j] -- != 0) {
                nums[i ++] = j;
            }
        }
    }

}
