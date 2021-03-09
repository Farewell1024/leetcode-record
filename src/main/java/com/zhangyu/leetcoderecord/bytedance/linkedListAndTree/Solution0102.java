package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Function: 102. 二叉树的层序遍历
 *
 * @author zhangyu
 * Date: 2021/3/3 17:13
 * @since JDK 1.8
 */
public class Solution0102 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        head.left = left;
        head.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        Solution0102 solution = new Solution0102();
        System.out.println(solution.levelOrder2(head));
    }

    /**
     * Queue 队列实现
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> subResult  = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    subResult.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(subResult);
            }
        }
        return result;
    }

    /**
     * 使用递归实现 手动记录层级 下探一级，层级加1
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了13.32%的用户
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(root, 0, result);
        return result;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        DFS(root.left, level + 1, result);
        DFS(root.right, level + 1, result);
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
