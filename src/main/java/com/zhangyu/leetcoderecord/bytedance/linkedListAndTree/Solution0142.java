package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 142. 环形链表 II
 *
 * @author zhangyu
 * Date: 2021/3/15 09:47
 * @since JDK 1.8
 */
public class Solution0142 {

    public static void main(String[] args) {
        Solution0142 solution = new Solution0142();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(solution.detectCycle(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println(solution.detectCycle(head2));

        System.out.println(solution.detectCycle(new ListNode(1)));
    }

    /**
     * 双指针
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null) {
            slow = slow.next;
            if (quick.next == null) {
                return null;
            }
            quick = quick.next.next;
            if (slow == quick) {
                while (head != quick) {
                    head = head.next;
                    quick = quick.next;
                }
                return head;
            }
        }
        return null;
    }

    /**
     * Set 解法
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    @ToString(exclude = "next")
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
