package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 98. 验证二叉搜索树
 *
 * @author zhangyu
 * Date: 2020/10/21 17:34
 * @since JDK 1.8
 */
public class Solution0098 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        head.left = left;
        head.right = right;

        Solution0098 solution = new Solution0098();
        System.out.println(solution.isValidBST(head));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer max, Integer min){
        if (root == null) {
            return true;
        }
        if (max != null && root.val>=max) return false;
        if (min != null && root.val<=min) return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
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
