package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 144. 二叉树的前序遍历
 *
 * @author zhangyu
 * Date: 2020/10/27 09:43
 * @since JDK 1.8
 */
public class Solution0144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));


        Solution0144 solution = new Solution0144();
        System.out.println(solution.preorderTraversal(root));
    }

    /**
     * Morris 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            result.add(cur.val);
            if (cur.left == null){
                cur = cur.right;
            }else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur.right){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur.right;
                } else {
                    mostRight.right = null;
                }
                cur = cur.left;
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
