package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

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
                TreeNode.buildFromArray(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                TreeNode.buildFromArray(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8})
        ));
        System.out.println(solution.leafSimilar(TreeNode.buildFromArray(new Integer[]{1}), TreeNode.buildFromArray(new Integer[]{1})));
        System.out.println(solution.leafSimilar(TreeNode.buildFromArray(new Integer[]{1}), TreeNode.buildFromArray(new Integer[]{2})));
        System.out.println(solution.leafSimilar(TreeNode.buildFromArray(new Integer[]{1, 2}), TreeNode.buildFromArray(new Integer[]{2, 2})));
        System.out.println(solution.leafSimilar(
                TreeNode.buildFromArray(new Integer[]{1, 2, 3}),
                TreeNode.buildFromArray(new Integer[]{1, 3, 2})
        ));
    }

    /**
     * 中序遍历 分别获取两个二叉树的叶子结点，再进行比较
     * <p>
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

}
