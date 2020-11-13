package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 328. 奇偶链表
 *
 * @author zhangyu
 * Date: 2020/11/13 09:31
 * @since JDK 1.8
 */
public class Solution0328 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        Solution0328 solution = new Solution0328();
        ListNode listNode = solution.oddEvenList(root);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 遍历一次，使用flag标记是否为奇数位
     */
    public ListNode oddEvenList(ListNode head) {
        boolean isOdd = true;
        ListNode oddHead = new ListNode(-1), evenHead = new ListNode(-1);
        ListNode currentOdd = oddHead, currentEven = evenHead;
        while (head != null) {
            if (isOdd) {
                currentOdd.next = head;
                currentOdd = currentOdd.next;
                isOdd = false;
            } else {
                currentEven.next = head;
                currentEven = currentEven.next;
                isOdd = true;
            }
            head = head.next;
        }
        currentOdd.next = evenHead.next;
        currentEven.next = null;
        return oddHead.next;
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
