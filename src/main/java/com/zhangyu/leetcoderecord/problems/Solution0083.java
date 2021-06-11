package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 83. 删除排序链表中的重复元素
 *
 * @author zhangyu
 * Date: 6/11/21
 * @since JDK 1.8
 */
public class Solution0083 {

    public static void main(String[] args) {
        Solution0083 solution = new Solution0083();
        ListNode.print(solution.deleteDuplicates(ListNode.buildFromArray(new int[]{1, 1, 2})));
        ListNode.print(solution.deleteDuplicates(ListNode.buildFromArray(new int[]{1, 1, 2, 3, 3})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmp = head.next, pre = head;
        while (tmp != null) {
            if (pre.val == tmp.val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
