package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 111. 二叉树的最小深度
 *
 * @author zhangyu
 * Date: 2020/10/21 17:50
 * @since JDK 1.8
 */
public class Solution0111 {

    public static void main(String[] args) {
        Solution0111 solution = new Solution0111();
        System.out.println(solution.minDepth(TreeNode.buildFromArray(new Integer[]{3,9,20,null,null,15,7})));
    }

    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }
    public int minDepth(TreeNode root, int level) {
        if (root == null) return 0;
        int left = minDepth(root.left, level+1);
        int right = minDepth(root.right, level+1);
        return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left, right);
    }

}
