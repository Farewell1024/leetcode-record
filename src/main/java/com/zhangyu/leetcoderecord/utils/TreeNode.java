package com.zhangyu.leetcoderecord.utils;

/**
 * Function: 通用二叉树
 *
 * @author zhangyu
 * Date: 2021/5/17
 * @since JDK 1.8
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 从数组构建一棵二叉树
     */
    public static TreeNode buildFromArray(Integer[] arr) {
        return buildFromArray(arr, 0);
    }

    private static TreeNode buildFromArray(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = buildFromArray(arr, 2 * index + 1);
        root.right = buildFromArray(arr, 2 * index + 2);
        return root;
    }

}
