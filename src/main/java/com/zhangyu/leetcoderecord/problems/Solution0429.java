package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 429. N 叉树的层序遍历
 *
 * @author zhangyu
 * Date: 2020/12/4 11:55
 * @since JDK 1.8
 */
public class Solution0429 {

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
        Solution0429 solution = new Solution0429();
        System.out.println(solution.levelOrder(root));
    }

    /**
     * 采用队列
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = stack.pop();
                list.add(cur.val);
                if (cur.children != null) {
                    stack.addAll(cur.children);
                }
            }
            result.add(list);
        }
        return result;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
