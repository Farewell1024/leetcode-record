package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 617. 合并二叉树
 *
 * @author zhangyu
 * Date: 2020/10/26 10:29
 * @since JDK 1.8
 */
public class Solution0617 {

    public static void main(String[] args) {
        Solution0617 solution = new Solution0617();
        TreeNode result = solution.mergeTrees(
                TreeNode.buildFromArray(new Integer[]{1, 3, 2, 5}),
                TreeNode.buildFromArray(new Integer[]{2, 1, 3, null, 4, null, 7})
        );
        System.out.println("Test Finished !");
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
