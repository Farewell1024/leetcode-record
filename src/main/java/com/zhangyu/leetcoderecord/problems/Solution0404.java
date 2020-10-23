package com.zhangyu.leetcoderecord.problems;

import javax.swing.tree.TreeNode;

/**
 * Function: 404. 左叶子之和
 *
 * @author zhangyu
 * Date: 2020/10/23 16:55
 * @since JDK 1.8
 */
public class Solution0404 {

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

        Solution0404 solution = new Solution0404();
        System.out.println(solution.sumOfLeftLeaves(head));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) helper(root, false);
        return sum;
    }

    private int sum = 0;

    public void helper(TreeNode node, boolean isLeft) {
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
            return;
        }
        if (node.left != null) helper(node.left, true);
        if (node.right != null) helper(node.right, false);
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
