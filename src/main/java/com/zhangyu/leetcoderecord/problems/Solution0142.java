package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 142. 环形链表 II
 *
 * @author zhangyu
 * Date: 2020/10/15 14:05
 * @since JDK 1.8
 */
public class Solution0142 {

    public static void main(String[] args) {
        Solution0142 solution = new Solution0142();
        System.out.println(solution.detectCycle(ListNode.buildFromArray(new int[]{3, 2, 0, -4})));
        System.out.println(solution.detectCycle(ListNode.buildFromArray(new int[]{1, 2})));
        System.out.println(solution.detectCycle(new ListNode(1)));
    }

    /**
     * 采用Set记录元素，找到环元素
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode next = head;
        while (next != null) {
            if (set.contains(next)) {
                return next;
            }
            set.add(next);
            next = next.next;
        }
        return null;
    }

    /**
     * 采用快慢指针，需理解，从快慢指针相遇点到环节点的距离 等于 初始点到环节点的距离
     */
    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode interact = null;

        ListNode prevNode = new ListNode(-1);
        prevNode.next = head;

        ListNode slow = prevNode.next;
        ListNode quick = prevNode.next.next;
        while (slow != null && quick!= null) {
            if (slow == quick) {
                interact = slow;
                break;
            } else {
                slow = slow.next;
                quick = quick.next;
                if (quick == null){
                    return null;
                }
                quick = quick.next;
            }
        }
        if (interact == null) {
            return null;
        }
        // 重点理解 为何相等
        ListNode h1 = prevNode;
        ListNode i1 = interact;
        while (h1 != i1){
            h1 = h1.next;
            i1 = i1.next;
        }
        return h1;
    }

}
