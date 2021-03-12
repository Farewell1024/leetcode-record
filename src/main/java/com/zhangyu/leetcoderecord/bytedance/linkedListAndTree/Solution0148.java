package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

/**
 * Function: 148. 排序链表
 *
 * @author zhangyu
 * Date: 2021/3/12 10:00
 * @since JDK 1.8
 */
public class Solution0148 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode head3 = new ListNode();
        Solution0148 solution = new Solution0148();
        print(solution.sortList(head1));
        print(solution.sortList(head2));
        print(solution.sortList(head3));

//        print(solution.merge(new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(2, new ListNode(3))));
    }

    /**
     * TODO 自下而上的归并 待实现
     */
    public ListNode sortList(ListNode head) {
        int length = 1;
        return null;
    }

    /**
     * 归并排序 自上而下 使用递归
     */
    public ListNode sortList2(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick != tail) {
            slow = slow.next;
            quick = quick.next;
            if (quick != tail) quick = quick.next;
        }
        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, quick);
        return merge(left, right);
    }

    /**
     * 合并两个有序链表 结果还是有序的
     */
    private ListNode merge(ListNode first, ListNode second) {
        ListNode tmp = new ListNode(), cur = tmp;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) cur.next = first;
        if (second != null) cur.next = second;
        return tmp.next;
    }

    /**
     * 打印链表
     */
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
