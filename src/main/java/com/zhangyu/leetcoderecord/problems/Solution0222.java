package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 222. 完全二叉树的节点个数
 *
 * @author zhangyu
 * Date: 2020/11/24 09:30
 * @since JDK 1.8
 */
public class Solution0222 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;

        Solution0222 solution = new Solution0222();
        System.out.println(solution.countNodes(root));
        System.out.println(solution.countNodes2(root));

    }

    /**
     * 递归
     */
    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Morris
     */
    public int countNodes2(TreeNode root) {
        int count = 0;
        TreeNode cur = root;
        while (cur != null) {
            count ++;
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right !=cur.right) {
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
        return count;
    }

    /**
     * 练习Morris遍历
     */
    private void morris(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            System.out.println(cur.val);
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right !=cur.right) {
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
