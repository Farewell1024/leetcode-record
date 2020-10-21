package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 104. 二叉树的最大深度
 *
 * @author zhangyu
 * Date: 2020/10/21 17:48
 * @since JDK 1.8
 */
public class Solution0104 {

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

        Solution0104 solution = new Solution0104();
        System.out.println(solution.maxDepth(head));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth2(root, 0);
    }

    public int maxDepth2(TreeNode root, int level) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth2(root.left, level+1), maxDepth2(root.right, level + 1));
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
