package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 501. 二叉搜索树中的众数
 *
 * @author zhangyu
 * Date: 2020/10/23 16:59
 * @since JDK 1.8
 */
public class Solution0501 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        Solution0501 solution = new Solution0501();
        System.out.println(Arrays.toString(solution.findMode(treeNode1)));
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> timeMap = new HashMap<>();
        helper(root, timeMap);
        List<Integer> result = new ArrayList<>();
        int max = 1;
        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            } else if (entry.getValue() > max) {
                result.clear();
                max = entry.getValue();
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void helper(TreeNode root, Map<Integer, Integer> timeMap){
        if (root == null) {
            return;
        }
        helper(root.left, timeMap);
        timeMap.put(root.val, timeMap.getOrDefault(root.val, 0) + 1);
        helper(root.right, timeMap);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
