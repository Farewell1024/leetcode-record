package com.zhangyu.leetcoderecord.problems;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Function: 143. 重排链表
 *
 * @author zhangyu
 * Date: 2020/10/20 09:34
 * @since JDK 1.8
 */
public class Solution0143 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);
        Solution0143 solution = new Solution0143();
        solution.reorderList(head);
        System.out.println("Test Finished !");
    }

    /**
     * 不属于官方解法，采用双向链表，效率略低
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        boolean isHead = false;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            deque.add(tmpNode);
        }
        tmpNode = head;
        while (!deque.isEmpty()) {
            if (isHead){
                tmpNode.next = deque.remove();
                isHead = false;
            } else {
                tmpNode.next = deque.removeLast();
                isHead = true;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode.next = null;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
