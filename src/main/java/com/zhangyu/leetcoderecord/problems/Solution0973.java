package com.zhangyu.leetcoderecord.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Function: 973. 最接近原点的 K 个点
 *
 * @author zhangyu
 * Date: 2020/11/9 09:47
 * @since JDK 1.8
 */
public class Solution0973 {

    public static void main(String[] args) {
        Solution0973 solution = new Solution0973();
        System.out.println(Arrays.stream(solution.kClosest2(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, 1)).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(solution.kClosest2(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4},
        }, 2)).map(Arrays::toString).collect(Collectors.joining(",")));
    }

    /**
     * 大根堆 自我实现
     */
    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comparator = (x, x2) -> (x2[0] * x2[0] + x2[1] * x2[1]) - (x[0] * x[0] + x[1] * x[1])  ;
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        for (int[] point : points) {
            if (queue.size() >= K) {
                if (comparator.compare(queue.peek(), point) < 0) {
                    queue.poll();
                    queue.add(point);
                }
            } else {
                queue.add(point);
            }
        }
        return queue.toArray(new int[0][]);
    }

    /**
     * 官方解法 1 ： 排序后截取
     */
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]*x[0] + x[1]*x[1]));
        return Arrays.copyOf(points, K);
    }

}
