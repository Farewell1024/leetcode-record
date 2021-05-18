package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 2. 两数相加
 *
 * @author zhangyu
 * Date: 2020/10/15 13:51
 * @since JDK 1.8
 */
public class Solution0002 {

    public static void main(String[] args) {
        Solution0002 solution = new Solution0002();
        ListNode.print(solution.addTwoNumbers(
                ListNode.buildFromArray(new int[]{2, 4, 3}),
                ListNode.buildFromArray(new int[]{5, 6, 4})
        ));
        ListNode.print(solution.addTwoNumbers(new ListNode(0), new ListNode(0)));
        ListNode.print(solution.addTwoNumbers(
                ListNode.buildFromArray(new int[]{9, 9, 9, 9, 9, 9, 9}),
                ListNode.buildFromArray(new int[]{9, 9, 9, 9})
        ));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmpL1 = l1, tmpL2 = l2, tmpNode = head;

        // 进位
        int carry = 0;
        while (tmpL1 != null || tmpL2 != null) {
            int a = tmpL1 == null ? 0 : tmpL1.val;
            int b = tmpL2 == null ? 0 : tmpL2.val;
            int sum = carry + a + b;
            carry = sum / 10;
            tmpNode.next = new ListNode(sum % 10);
            tmpNode = tmpNode.next;
            if (tmpL1 != null) {
                tmpL1 = tmpL1.next;
            }
            if (tmpL2 != null) {
                tmpL2 = tmpL2.next;
            }
        }
        if (carry > 0) {
            tmpNode.next = new ListNode(carry);
        }
        return head.next;
    }

}
