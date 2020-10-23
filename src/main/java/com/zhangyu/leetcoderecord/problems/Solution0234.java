package com.zhangyu.leetcoderecord.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 234. 回文链表
 *
 * @author zhangyu
 * Date: 2020/10/23 09:39
 * @since JDK 1.8
 */
public class Solution0234 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        Solution0234 solution = new Solution0234();

        System.out.println(solution.isPalindrome(listNode1));
        System.out.println(solution.isPalindrome(null));
        System.out.println(solution.isPalindrome2(listNode1));
        System.out.println(solution.isPalindrome2(null));
    }

    /**
     * 自己解法 将无序链表转换成有序数组
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int i,j;
        if ((list.size() & 1) == 0) {
            i = list.size() / 2 - 1;
            j = i+1;
        } else {
            i = j = list.size() / 2;
        }
        for (; i >= 0; i--, j++){
            if ( ! list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }

    /**
     * 拿到中间节点，反转中间节点后的一段链表，与第一段比较
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {return true;}
        // 获取中间节点
        ListNode center = center(head);
        // 反转中间节点后的链表
        ListNode newHead = reverse(center);
        while (newHead != null){
            if (newHead.val != head.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }


    private ListNode center(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = previous;
            previous = current;
            current = tmpNext;
        }
        return previous;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
