package com.zhangyu.leetcoderecord.problems.unfinished;

import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 6/17/21
 * @since JDK 1.8
 */
public class Solution0145 {

    public static void main(String[] args) {
        Solution0145 solution = new Solution0145();
        TreeNode treeNode = TreeNode.buildFromArray(new Integer[]{1, null, 2, null, null, 3});
        System.out.println(solution.postorderTraversal(treeNode));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }


}
