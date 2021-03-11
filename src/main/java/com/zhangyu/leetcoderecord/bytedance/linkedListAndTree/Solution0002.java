package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

/**
 * Function: 2. 两数相加
 *
 * @author zhangyu
 * Date: 2021/3/11 09:32
 * @since JDK 1.8
 */
public class Solution0002 {

    public static void main(String[] args) {
        Solution0002 solution = new Solution0002();
        print(solution.addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ));
        print(solution.addTwoNumbers(new ListNode(0), new ListNode(0)));
        print(solution.addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                        new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))
        ));
    }

    /**
     * 按照正常思维，从头到尾依次相加，需要进位就进位
     * 都相加完后需要进位的话，就新建一个节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1), result = tmp;
        int a = 0;
        while (l1 != null || l2 != null) {
            int b = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + a;
            a = b / 10;
            tmp.next = new ListNode(b % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null)l2 = l2.next;
            tmp = tmp.next;
        }
        if (a != 0) tmp.next = new ListNode(a);
        return result.next;
    }

    private static void print(ListNode listNode) {
        ListNode tmp = listNode;
        while (tmp != null) {
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
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
