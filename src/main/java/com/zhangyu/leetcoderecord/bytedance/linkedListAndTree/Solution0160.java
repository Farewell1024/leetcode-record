package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 160. 相交链表
 *
 * @author zhangyu
 * Date: 2021/3/15 14:19
 * @since JDK 1.8
 */
public class Solution0160 {

    public static void main(String[] args) {
        Solution0160 solution = new Solution0160();

        ListNode h1 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode h2 = new ListNode(5);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(1);
        h1.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        h2.next = n5;
        n5.next = n6;
        n6.next = n2;
        System.out.println(solution.getIntersectionNode(h1, h2));

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        System.out.println(solution.getIntersectionNode(l1, l4));
    }

    /**
     * Set
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针
     * 每个链表需要遍历两次
     * <p>
     * 从两个节点的头开始遍历，假设当A节点到末尾的时候，将A节点指向B节点的开头
     * 继续遍历，当B节点到末尾的时候，将B节点指向A节点的开头。
     * 这样A节点到末尾的距离 就等于B节点到末尾的距离了
     * 再从此开始遍历， 如果有相交节点，返回
     * 如果无相交节点的话，两哥指针会同时到达链表末尾
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = (n1 == null ? headB : n1.next);
            n2 = (n2 == null ? headA : n2.next);
        }
        return n1;
    }

    @ToString(exclude = "next")
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
