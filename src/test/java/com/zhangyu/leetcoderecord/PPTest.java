package com.zhangyu.leetcoderecord;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 11/13/22
 * @since JDK 1.8
 */
public class PPTest {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode re = reverseList(listNode);
        ListNode.print(re);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head!= null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
