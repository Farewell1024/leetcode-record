package com.zhangyu.leetcoderecord.problems;


/**
 * Function: 236. 二叉树的最近公共祖先
 *
 * @author zhangyu
 * Date: 2020/10/23 16:35
 * @since JDK 1.8
 */
public class Solution0236 {

    public static void main(String[] args) {
         TreeNode head = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode leftLeft = new TreeNode(6);
        TreeNode leftRight = new TreeNode(2);
        TreeNode leftRightLeft = new TreeNode(7);
        TreeNode leftRightRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(0);
        TreeNode rightRight = new TreeNode(8);
        head.left = left;
        head.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        leftRight.left = leftRightLeft;
        leftRight.right = leftRightRight;
        right.left = rightLeft;
        right.right = rightRight;

        Solution0236 solution = new Solution0236();
        System.out.println(solution.lowestCommonAncestor(head, left, right).val);
        System.out.println(solution.lowestCommonAncestor(head, left, leftRightRight).val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
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
