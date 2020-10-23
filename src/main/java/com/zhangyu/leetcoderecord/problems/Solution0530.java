package com.zhangyu.leetcoderecord.problems;

import javax.swing.tree.TreeNode;

/**
 * Function: 530. 二叉搜索树的最小绝对差
 *
 * @author zhangyu
 * Date: 2020/10/23 17:09
 * @since JDK 1.8
 */
public class Solution0530 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        Solution0530 solution = new Solution0530();
        System.out.println(solution.getMinimumDifference(treeNode1));
    }

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }

    private int ans = Integer.MAX_VALUE;
    private int pre = -1;

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != -1) {
            ans = Math.min(ans, (root.val - pre));
        }
        pre = root.val;
        helper(root.right);
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
