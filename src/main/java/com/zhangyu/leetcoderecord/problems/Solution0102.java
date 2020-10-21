package com.zhangyu.leetcoderecord.problems;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Function: 102. 二叉树的层序遍历
 *
 * @author zhangyu
 * Date: 2020/10/21 17:44
 * @since JDK 1.8
 */
public class Solution0102 {

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

        Solution0102 solution = new Solution0102();
        System.out.println(solution.levelOrder(head));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder2(root, 0);
        return result;
    }

    public void levelOrder2(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrder2(root.left, level + 1);
        levelOrder2(root.right, level + 1);
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
