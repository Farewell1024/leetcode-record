package com.zhangyu.leetcoderecord.geek;

import com.zhangyu.leetcoderecord.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Function:  Linked List Cycle
 *
 * @author Yu Zhang
 * Date: 12/4/22
 * @since JDK 1.8
 */
public class Question0141 {

    public static void main(String[] args) {
//        System.out.println(new Question0141().hasCycle(ListNode.buildFromArray(new int[]{3,2,0,-4})));
//        System.out.println(new Question0141().hasCycle(ListNode.buildFromArray(new int[]{1,2})));
        System.out.println(new Question0141().hasCycle(ListNode.buildFromArray(new int[]{1})));
    }

    /**
     * double pointer 3
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next, quick = slow.next;
        while (quick != slow) {
            if (quick == null || quick.next == null) {
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * double pointer
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next, quick = slow.next;
        while (slow != null && quick != null) {
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next == null ? null : quick.next.next;
        }
        return false;
    }

    /**
     * set
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
