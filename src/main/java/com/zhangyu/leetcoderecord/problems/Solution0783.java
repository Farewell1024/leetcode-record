package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 783. 二叉搜索树节点最小距离
 *
 * @author zhangyu
 * Date: 2021/4/13 10:08
 * @since JDK 1.8
 */
public class Solution0783 {

    public static void main(String[] args) {
        Solution0783 solution = new Solution0783();
        System.out.println(solution.minDiffInBST(new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6))));
        System.out.println(solution.minDiffInBST(new TreeNode(1,
                new TreeNode(0),
                new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
    }

    int ans = Integer.MAX_VALUE, pre = -1;

    /**
     * 因二叉搜索树的特性，两节点之间的最小值必定是 某相邻两个节点的差
     * 所以采用中序遍历的形式进行计算
     * 需要记录上一个节点的，并与此节点进行相减
     */
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(treeNode.val - pre));
        }
        pre = treeNode.val;
        helper(treeNode.right);
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
