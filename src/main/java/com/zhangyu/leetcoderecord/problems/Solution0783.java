package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

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
        System.out.println(solution.minDiffInBST(TreeNode.buildFromArray(new Integer[]{4, 2, 6, 1, 3})));
        System.out.println(solution.minDiffInBST(TreeNode.buildFromArray(new Integer[]{1, 0, 48, null, null, 12, 49})));

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

}
