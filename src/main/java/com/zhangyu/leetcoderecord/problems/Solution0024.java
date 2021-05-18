package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function:  24. 两两交换链表中的节点
 *
 * @author zhangyu
 * Date: 2020/10/15 14:00
 * @since JDK 1.8
 */
public class Solution0024 {

    public static void main(String[] args) {
        Solution0024 solution = new Solution0024();
        ListNode.print(solution.swapPairs(ListNode.buildFromArray(new int[]{1, 2, 3, 4})));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode prevNode = tmp;
        while (head != null && head.next != null) {
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

}
