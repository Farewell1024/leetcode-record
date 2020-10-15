package com.zhangyu.leetcoderecord.problems;

/**
 * Function:  206. 反转链表
 *
 * @author zhangyu
 * Date: 2020/10/15 13:53
 * @since JDK 1.8
 */
public class Solution0206 {

    public static void main(String[] args) {
        Solution0206 solution = new Solution0206();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = solution.reverseList(listNode1);
        System.out.println("Test Finished !");
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = previous;
            previous = current;
            current = tmpNext;
        }
        return previous;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
