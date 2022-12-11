package com.zhangyu.leetcoderecord.problems.unfinished;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 147. 对链表进行插入排序
 *
 * @author zhangyu
 * Date: 2020/11/20 09:28
 * @since JDK 1.8
 */
public class Solution0147 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution0147 solution = new Solution0147();
        ListNode node = solution.insertionSortList(node1);

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmpNode = new ListNode(Integer.MIN_VALUE);
        tmpNode.next = head;

        return head;
    }

}
