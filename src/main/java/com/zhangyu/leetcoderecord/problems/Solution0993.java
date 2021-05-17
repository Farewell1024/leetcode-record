package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.TreeNode;

/**
 * Function: 993. 二叉树的堂兄弟节点
 *
 * @author zhangyu
 * Date: 2021/5/17
 * @since JDK 1.8
 */
public class Solution0993 {

    public static void main(String[] args) {
        Solution0993 solution = new Solution0993();
        System.out.println(solution.isCousins(TreeNode.buildFromArray(new Integer[]{1, 2, 3, 4}), 4, 3));
        System.out.println(solution.isCousins(TreeNode.buildFromArray(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
        System.out.println(solution.isCousins(TreeNode.buildFromArray(new Integer[]{1, 2, 3, null, 4}), 2, 3));
    }

    private int x;
    private boolean xFound;
    private int xFather;
    private int xDepth;

    private int y;
    private boolean yFound;
    private int yFather;
    private int yDepth;

    /**
     * 深度优先搜索
     * 分别记录x/y的是否找到，深度，父节点
     *
     * same as 官方解法1
     * but 优化的点是：parent采用int来表示，而非题解中的TreeNode
     * 因为每个节点的值是  1-100，且不重复
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        helper(root, 0,0);
        return (xDepth == yDepth) && (xFather != yFather);
    }

    private void helper(TreeNode root, int depth, int parent){
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xFound = true;
            xDepth = depth;
            xFather = parent;
        } else if (root.val == y) {
            yFound = true;
            yDepth = depth;
            yFather = parent;
        }
        if (xFound && yFound) {
            return;
        }
        helper(root.left, depth + 1, root.val);
        if (xFound && yFound) {
            return;
        }
        helper(root.right, depth + 1, root.val);
    }
}
