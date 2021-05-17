package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 102. 二叉树的层序遍历
 *
 * @author zhangyu
 * Date: 2020/10/21 17:44
 * @since JDK 1.8
 */
public class Solution0102 {

    public static void main(String[] args) {
        Solution0102 solution = new Solution0102();
        System.out.println(solution.levelOrder(TreeNode.buildFromArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder2(root, 0);
        return result;
    }

    public void levelOrder2(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrder2(root.left, level + 1);
        levelOrder2(root.right, level + 1);
    }

}
