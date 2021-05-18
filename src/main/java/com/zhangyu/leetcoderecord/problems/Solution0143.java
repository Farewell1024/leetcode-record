package com.zhangyu.leetcoderecord.problems;


import com.zhangyu.leetcoderecord.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Function: 143. 重排链表
 *
 * @author zhangyu
 * Date: 2020/10/20 09:34
 * @since JDK 1.8
 */
public class Solution0143 {

    public static void main(String[] args) {
        Solution0143 solution = new Solution0143();
        solution.reorderList(ListNode.buildFromArray(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 不属于官方解法，采用双向链表，效率略低
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        boolean isHead = false;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            deque.add(tmpNode);
        }
        tmpNode = head;
        while (!deque.isEmpty()) {
            if (isHead) {
                tmpNode.next = deque.remove();
                isHead = false;
            } else {
                tmpNode.next = deque.removeLast();
                isHead = true;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode.next = null;
    }

}
