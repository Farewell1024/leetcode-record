package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 872. 叶子相似的树
 *
 * @author zhangyu
 * Date: 2021/5/10
 * @since JDK 1.8
 */
public class Solution0872 {

    public static void main(String[] args) {
        Solution0872 solution = new Solution0872();
        System.out.println(solution.leafSimilar(
                new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8))),
                new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))))
        ));
        System.out.println(solution.leafSimilar(new TreeNode(1), new TreeNode(1)));
        System.out.println(solution.leafSimilar(new TreeNode(1), new TreeNode(2)));
        System.out.println(solution.leafSimilar(new TreeNode(1, new TreeNode(2), null), new TreeNode(2, new TreeNode(2), null)));
        System.out.println(solution.leafSimilar(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(3), new TreeNode(2))
        ));
    }

    /**
     * 中序遍历 分别获取两个二叉树的叶子结点，再进行比较
     *
     * Tips ： AbstractList类中重写了equals方法，可以直接进行比较
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>(), r2 = new ArrayList<>();
        helper(root1, r1);
        helper(root2, r2);
        return r1.equals(r2);
//        if (r1.size() != r2.size()) return false;
//        for (int i = 0; i < r1.size(); i++) {
//            if (!r1.get(i).equals(r2.get(i))) {
//                return false;
//            }
//        }
//        return true;
    }

    private void helper(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, result);
        if (treeNode.left == null && treeNode.right == null) {
            result.add(treeNode.val);
        }
        helper(treeNode.right, result);
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
