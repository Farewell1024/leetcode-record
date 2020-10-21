package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 2. 两数相加
 *
 * @author zhangyu
 * Date: 2020/10/15 13:51
 * @since JDK 1.8
 */
public class Solution0002 {

    public static void main(String[] args) {
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        Solution0002 Solution = new Solution0002();
        ListNode listNode = Solution.addTwoNumbers(first, second);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
