package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

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
        Solution0141 solution = new Solution0141();
        System.out.println(solution.hasCycle(ListNode.buildFromArray(new int[]{3, 2, 0, -4})));
        System.out.println(solution.hasCycle2(ListNode.buildFromArray(new int[]{3, 2, 0, -4})));
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
        while (slow != null && quick != null) {
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next;
            if (quick == null) {
                return false;
            }
            quick = quick.next;
        }
        return false;
    }

}
