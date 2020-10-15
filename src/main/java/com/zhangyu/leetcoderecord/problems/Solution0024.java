package com.zhangyu.leetcoderecord.problems;

/**
 * Function:  24. 两两交换链表中的节点
 *
 * @author zhangyu
 * Date: 2020/10/15 14:00
 * @since JDK 1.8
 */
public class Solution0024 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Solution0024 solution = new Solution0024();
        ListNode result = solution.swapPairs(listNode1);
        System.out.println("Test Finished !");
    }

    public ListNode swapPairs(ListNode head) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode prevNode = tmp;
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;
            prevNode.next = second;
            first.next = second.next;
            second.next = first;
            prevNode = first;
            head = first.next;
        }
        return tmp.next;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
