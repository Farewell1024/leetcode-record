package com.zhangyu.leetcoderecord.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Function: 116. 填充每个节点的下一个右侧节点指针
 *
 * @author zhangyu
 * Date: 2020/10/21 13:55
 * @since JDK 1.8
 */
public class Solution0116 {
    public static void main(String[] args) {
        Node leftLeft = new Node(4);
        Node leftRight = new Node(5);
        Node left = new Node(2, leftLeft, leftRight, null);
        Node rightLeft = new Node(6);
        Node rightRight = new Node(7);
        Node right = new Node(3, rightLeft, rightRight, null);
        Node root = new Node(1, left, right, null);

        Solution0116 solution = new Solution0116();
        Node connect = solution.connect3(root);
        System.out.println("test finish !");
    }

    /**
     * version 1 ; 使用双队列
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> first = new LinkedList<>();
        Queue<Node> second = new LinkedList<>();
        first.add(root);
        Node pre = new Node(-1);
        while (!first.isEmpty()) {
            Node current = first.remove();
            if(current.left != null) second.add(current.left);
            if(current.right != null)second.add(current.right);
            pre.next = current;
            pre = current;
            if (first.isEmpty()){
                pre = new Node(-1);
                while (!second.isEmpty()) {
                    first.add(second.remove());
                }
            }
        }
        return root;
    }

    /**
     * Version2 ; 使用单个队列  官方解法1
     */
    public Node connect2(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.remove();
                if (i < size - 1 ){
                    current.next = queue.peek();
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return root;
    }

    /**
     * Version3 : 不使用额外空间 官方题解2
     */
    public Node connect3(Node root) {
        if (root == null) return root;
        Node one = root;
        while (one.left != null){
            Node current = one;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            one = one.left;
        }
        return root;
    }




    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
