package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 404. 左叶子之和
 *
 * @author zhangyu
 * Date: 2020/10/23 16:55
 * @since JDK 1.8
 */
public class Solution0404 {

    public static void main(String[] args) {
        Solution0404 solution = new Solution0404();
        System.out.println(solution.sumOfLeftLeaves(TreeNode.buildFromArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) helper(root, false);
        return sum;
    }

    private int sum = 0;

    public void helper(TreeNode node, boolean isLeft) {
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
            return;
        }
        if (node.left != null) helper(node.left, true);
        if (node.right != null) helper(node.right, false);
    }

}
