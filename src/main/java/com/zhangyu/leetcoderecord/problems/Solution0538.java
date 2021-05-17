package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 538. 把二叉搜索树转换为累加树
 *
 * @author zhangyu
 * Date: 2020/10/23 17:12
 * @since JDK 1.8
 */
public class Solution0538 {

    public static void main(String[] args) {
        Solution0538 solution = new Solution0538();
        TreeNode result = solution.convertBST(TreeNode.buildFromArray(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8}));
        System.out.println("Test Finished !");
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    private int sum = 0;

}
