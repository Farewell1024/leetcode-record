package com.zhangyu.leetcoderecord.problems;

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
        System.out.println(solution.isSameTree(null, null));
        System.out.println(solution.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(solution.isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null,
                new TreeNode(2))));
        System.out.println(solution.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), new TreeNode(2))));
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
