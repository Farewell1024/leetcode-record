package com.zhangyu.leetcoderecord.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 141. 环形链表
 *
 * @author zhangyu
 * Date: 2020/10/15 14:05
 * @since JDK 1.8
 */
public class Solution0141 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        Solution0141 solution = new Solution0141();
        System.out.println(solution.hasCycle(listNode1));
        System.out.println(solution.hasCycle2(listNode1));
    }

    /**
     * Set 版本
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            if (set.contains(tmpNode)) {
                return true;
            }
            set.add(tmpNode);
            tmpNode = tmpNode.next;
        }
        return false;
    }

    /**
     * 快慢指针版本
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while (slow != null && quick != null){
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next;
            if (quick == null){
                return false;
            }
            quick = quick.next;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
