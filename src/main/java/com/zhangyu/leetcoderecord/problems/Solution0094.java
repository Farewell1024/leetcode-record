package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 94. 二叉树的中序遍历
 *
 * @author zhangyu
 * Date: 2020/10/21 17:30
 * @since JDK 1.8
 */
public class Solution0094 {

    public static void main(String[] args) {
        Solution0094 solution = new Solution0094();
        System.out.println(solution.inorderTraversal(TreeNode.buildFromArray(new Integer[]{1, null, 2, 3})));
        System.out.println(solution.inorderTraversal(TreeNode.buildFromArray(new Integer[]{})));
        System.out.println(solution.inorderTraversal(TreeNode.buildFromArray(new Integer[]{1})));
        System.out.println(solution.inorderTraversal(TreeNode.buildFromArray(new Integer[]{1, 2})));
        System.out.println(solution.inorderTraversal(TreeNode.buildFromArray(new Integer[]{1, null, 2})));
    }

    /**
     * Morris遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        TreeNode mostRight = null;
        while (current != null) {
            if (current.left != null) {
                mostRight = current.left;
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

}
