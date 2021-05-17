package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 100. 相同的树
 *
 * @author zhangyu
 * Date: 2020/11/16 10:08
 * @since JDK 1.8
 */
public class Solution0100 {

    public static void main(String[] args) {
        Solution0100 solution = new Solution0100();
        System.out.println(solution.isSameTree(TreeNode.buildFromArray(new Integer[]{1, 2, 3}),
                TreeNode.buildFromArray(new Integer[]{1, 2, 3})));
        System.out.println(solution.isSameTree(TreeNode.buildFromArray(new Integer[]{1, 2}),
                TreeNode.buildFromArray(new Integer[]{1, null, 2})));
        System.out.println(solution.isSameTree(TreeNode.buildFromArray(new Integer[]{1, 2, 1}),
                TreeNode.buildFromArray(new Integer[]{1, 1, 2})));
    }

    /**
     * 递归
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
