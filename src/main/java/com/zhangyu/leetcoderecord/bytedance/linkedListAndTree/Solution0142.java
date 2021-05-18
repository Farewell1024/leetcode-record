package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import com.zhangyu.leetcoderecord.utils.ListNode;

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
        System.out.println(solution.detectCycle(ListNode.buildFromArray(new int[]{3, 2, 0, -4})));
        System.out.println(solution.detectCycle(ListNode.buildFromArray(new int[]{1, 2})));
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
}
