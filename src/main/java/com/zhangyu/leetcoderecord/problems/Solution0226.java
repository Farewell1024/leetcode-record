package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 226. 翻转二叉树
 *
 * @author zhangyu
 * Date: 2020/10/23 15:03
 * @since JDK 1.8
 */
public class Solution0226 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(9);
        head.left = left;
        head.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        Solution0226 solution = new Solution0226();
        TreeNode invertTree = solution.invertTree(head);
        System.out.println("Test Finished !");
    }

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        helper(node.left);
        helper(node.right);
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
