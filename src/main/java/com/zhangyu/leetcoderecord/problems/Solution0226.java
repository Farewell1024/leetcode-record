package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 226. 翻转二叉树
 *
 * @author zhangyu
 * Date: 2020/10/23 15:03
 * @since JDK 1.8
 */
public class Solution0226 {

    public static void main(String[] args) {
        Solution0226 solution = new Solution0226();
        TreeNode invertTree = solution.invertTree(TreeNode.buildFromArray(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
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

}
