package com.zhangyu.leetcoderecord.bytedance.arrayAndSort;

/**
 * Function: 547. 省份数量
 *
 * @author zhangyu
 * Date: 2021/3/4 11:29
 * @since JDK 1.8
 */
public class Solution0547 {

    public static void main(String[] args) {
        Solution0547 solution = new Solution0547();
        System.out.println(solution.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        }));
        System.out.println(solution.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        }));
        System.out.println(solution.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        }));
    }

    /**
     * 深度优先搜索
     * 采用布尔数组记录城市是否访问过，对于未访问过的城市，进行深度优先搜索，逐步找寻到与之直接连接的城市
     * 并将其访问记录置为true
     * e.g. 遍历A城市时发现其与B城市直接相连，紧接着就遍历与B城市直接相连的城市，以此类推
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了7.22%的用户
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] isVisited = new boolean[cities];
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (! isVisited[i]) {
                count ++;
                helper(isConnected, i, isVisited);
            }
        }
        return count;
    }

    private void helper(int[][] isConnected, int cityId, boolean[] isVisited){
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[cityId][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                helper(isConnected, i, isVisited);
            }
        }
    }
}
