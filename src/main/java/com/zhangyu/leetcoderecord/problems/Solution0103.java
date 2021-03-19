package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 103. 二叉树的锯齿形层序遍历
 *
 * @author zhangyu
 * Date: 2021/3/16 10:47
 * @since JDK 1.8
 */
public class Solution0103 {

    public static void main(String[] args) {
        Solution0103 solution = new Solution0103();
        System.out.println(solution.zigzagLevelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    /**
     * 层序遍历后 将奇数下标的list反序
     *
     * 官方题解中，使用一个boolean标签记录正反序，使用一个双端队列来进行存储
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                subResult.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            result.add(subResult);
        }
        for (int i = 1; i < result.size(); i += 2) {
            List<Integer> list = result.get(i);
            for (int l = 0, r = list.size() - 1; l < r; l++, r--) {
                Collections.swap(list, l, r);
            }
        }
        return result;
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