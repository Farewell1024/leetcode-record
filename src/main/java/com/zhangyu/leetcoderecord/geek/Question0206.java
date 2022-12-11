package com.zhangyu.leetcoderecord.geek;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 *  Reverse Linked List
 */
public class Question0206 {

    public static void main(String[] args) {
        Question0206 question = new Question0206();
        ListNode.print(question.reverseList(ListNode.buildFromArray(new int[]{1,2,3,4,5})));
        ListNode.print(question.reverseList(ListNode.buildFromArray(new int[]{1,2})));
        ListNode.print(question.reverseList(null));
    }

    /**
     * 使用一个指针来记录前一个节点，把当前节点的next指针指向前一个节点即可
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
