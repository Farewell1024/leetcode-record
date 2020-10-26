package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 617. 合并二叉树
 *
 * @author zhangyu
 * Date: 2020/10/26 10:29
 * @since JDK 1.8
 */
public class Solution0617 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;

        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(7);
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        treeNode6.right = treeNode8;
        treeNode7.right = treeNode9;

        Solution0617 solution = new Solution0617();
        TreeNode result = solution.mergeTrees(treeNode1, treeNode5);
        System.out.println("Test Finished !");
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
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
