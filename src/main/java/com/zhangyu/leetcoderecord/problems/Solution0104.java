package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 104. 二叉树的最大深度
 *
 * @author zhangyu
 * Date: 2020/10/21 17:48
 * @since JDK 1.8
 */
public class Solution0104 {

    public static void main(String[] args) {
        Solution0104 solution = new Solution0104();
        System.out.println(solution.maxDepth(TreeNode.buildFromArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth2(root, 0);
    }

    public int maxDepth2(TreeNode root, int level) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth2(root.left, level+1), maxDepth2(root.right, level + 1));
    }

}
