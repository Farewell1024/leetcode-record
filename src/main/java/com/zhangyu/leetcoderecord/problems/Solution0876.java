package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 876. 链表的中间结点
 * <p>
 * 本例中只写了快慢指针的办法，在官方解法中还有 1。数组存储； 2。单指针 两种解法。
 * <p>
 * 不如快慢指针爽
 *
 * @author zhangyu
 * Date: 2020/10/20 10:02
 * @since JDK 1.8
 */
public class Solution0876 {

    public static void main(String[] args) {
        Solution0876 solution = new Solution0876();
        ListNode result = solution.middleNode(ListNode.buildFromArray(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(result.val);
    }

    /**
     * 快慢指针
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

}
