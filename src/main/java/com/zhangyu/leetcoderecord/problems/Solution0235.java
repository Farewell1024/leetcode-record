package com.zhangyu.leetcoderecord.problems;

import lombok.Data;

import javax.swing.tree.TreeNode;

/**
 * Function: 235. 二叉搜索树的最近公共祖先
 *
 * @author zhangyu
 * Date: 2020/10/23 16:21
 * @since JDK 1.8
 */
public class Solution0235 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(4);
        TreeNode leftRightLeft = new TreeNode(3);
        TreeNode leftRightRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(9);
        head.left = left;
        head.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        leftRight.left = leftRightLeft;
        leftRight.right = leftRightRight;
        right.left = rightLeft;
        right.right = rightRight;

        Solution0235 solution = new Solution0235();
        System.out.println(solution.lowestCommonAncestor(head, left, right));
        System.out.println(solution.lowestCommonAncestor(head, left, leftRight));

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    @Data
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
