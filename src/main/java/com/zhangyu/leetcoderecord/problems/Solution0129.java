package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.Stack;

/**
 * Function: 129. 求根到叶子节点数字之和
 *
 * @author zhangyu
 * Date: 2020/10/29 09:44
 * @since JDK 1.8
 */
public class Solution0129 {

    public static void main(String[] args) {
        Solution0129 solution = new Solution0129();
        System.out.println(solution.sumNumbers2(TreeNode.buildFromArray(new Integer[]{1, 2, 3})));
        System.out.println(solution.sumNumbers2(TreeNode.buildFromArray(new Integer[]{4, 9, 0, 5, 1})));
    }

    /**
     * 使用栈
     * 可以通过，但有bug：会改变原节点的值
     */
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                result += node.val;
                continue;
            }
            if (node.left != null) {
                node.left.val += (node.val * 10);
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val += (node.val * 10);
                stack.push(node.right);
            }
        }
        return result;
    }

    /**
     * 递归
     */
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        return root.left == null && root.right == null ? sum : (helper(root.left, sum) + helper(root.right, sum));
    }

}
