package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 222. 完全二叉树的节点个数
 *
 * @author zhangyu
 * Date: 2020/11/24 09:30
 * @since JDK 1.8
 */
public class Solution0222 {

    public static void main(String[] args) {
        Solution0222 solution = new Solution0222();
        System.out.println(solution.countNodes(TreeNode.buildFromArray(new Integer[]{1,2,3,4,5,6})));
        System.out.println(solution.countNodes2(TreeNode.buildFromArray(new Integer[]{1,2,3,4,5,6})));
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

}
