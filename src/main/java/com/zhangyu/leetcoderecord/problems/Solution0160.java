package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

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
        System.out.println(solution.getIntersectionNode(
                ListNode.buildFromArray(new int[]{4, 1, 8, 4, 5}),
                ListNode.buildFromArray(new int[]{5, 0, 1, 8, 4, 5})
        ));
        System.out.println(solution.getIntersectionNode(
                ListNode.buildFromArray(new int[]{2, 5, 4}),
                ListNode.buildFromArray(new int[]{1, 5})
        ));
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
     *
     * 从两个节点的头开始遍历，假设当A节点到末尾的时候，将A节点指向B节点的开头
     * 继续遍历，当B节点到末尾的时候，将B节点指向A节点的开头。
     * 这样A节点到末尾的距离 就等于B节点到末尾的距离了
     * 再从此开始遍历， 如果有相交节点，返回
     * 如果无相交节点的话，两哥指针会同时到达链表末尾
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = (n1.next == null ? headB : n1.next);
            n2 = (n2.next == null ? headA : n2.next);
        }
        return n1;
    }

}
