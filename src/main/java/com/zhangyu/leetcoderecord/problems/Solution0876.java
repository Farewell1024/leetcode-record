package com.zhangyu.leetcoderecord.problems;

import java.util.List;

/**
 * Function: 876. 链表的中间结点
 *
 * 本例中只写了快慢指针的办法，在官方解法中还有 1。数组存储； 2。单指针 两种解法。
 *
 * 不如快慢指针爽
 *
 * @author zhangyu
 * Date: 2020/10/20 10:02
 * @since JDK 1.8
 */
public class Solution0876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        Solution0876 solution = new Solution0876();
        ListNode result = solution.middleNode(head);
        System.out.println(result.val);
    }

    /**
     * 快慢指针
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
