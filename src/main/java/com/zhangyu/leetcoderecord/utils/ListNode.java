package com.zhangyu.leetcoderecord.utils;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2021/5/18
 * @since JDK 1.8
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildFromArray(int[] arr) {
        ListNode head = new ListNode(-1), tmp = head;
        for (int i = 0; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head.next;
    }

    public static void print(ListNode listNode) {
        ListNode tmp = listNode;
        while (tmp != null) {
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
