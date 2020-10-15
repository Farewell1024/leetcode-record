package com.zhangyu.leetcoderecord.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 19. 删除链表的倒数第N个节点
 *
 * @author zhangyu
 * Date: 2020/10/15 14:15
 * @since JDK 1.8
 */
public class Solution0019 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution0019 solution = new Solution0019();
        ListNode result = solution.removeNthFromEnd(listNode1, 2);
        System.out.println("Test Finished !");
    }

    /**
     * 采用Map计数 删除指定倒数元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 1;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            map.put(count++, tmpNode);
            tmpNode = tmpNode.next;
        }
        map.put(count -n, null);
        if (map.get(count -n - 1) == null) {
            return map.get(count -n + 1);
        }else {
            map.get(count -n - 1).next = map.get(count -n + 1);
            return map.get(1);
        }
    }

    /**
     * 快慢指针。快指针比慢指针快N。
     * 当快指针到头的时候，慢指针就到了要删除的这个元素
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode quick = prev;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        ListNode slow = prev;
        while (quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prev.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
