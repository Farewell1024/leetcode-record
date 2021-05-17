package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 144. 二叉树的前序遍历
 *
 * @author zhangyu
 * Date: 2020/10/27 09:43
 * @since JDK 1.8
 */
public class Solution0144 {

    public static void main(String[] args) {
        Solution0144 solution = new Solution0144();
        System.out.println(solution.preorderTraversal(TreeNode.buildFromArray(new Integer[]{1,null,2,3})));
    }

    /**
     * Morris 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            result.add(cur.val);
            if (cur.left == null){
                cur = cur.right;
            }else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur.right){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur.right;
                } else {
                    mostRight.right = null;
                }
                cur = cur.left;
            }
        }
        return result;
    }

}
