package com.zhangyu.leetcoderecord.problems;

import javax.swing.tree.TreeNode;

/**
 * Function: 538. 把二叉搜索树转换为累加树
 *
 * @author zhangyu
 * Date: 2020/10/23 17:12
 * @since JDK 1.8
 */
public class Solution0538 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(6);
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(7);
        TreeNode leftRightRight = new TreeNode(3);
        TreeNode rightRightRight = new TreeNode(8);
        head.left = left;
        head.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        leftRight.right = leftRightRight;
        rightRight.right = rightRightRight;

        Solution0538 solution = new Solution0538();
        TreeNode result = solution.convertBST(head);
        System.out.println("Test Finished !");
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    private int sum = 0;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
