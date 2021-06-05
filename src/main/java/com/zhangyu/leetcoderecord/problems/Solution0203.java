package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 203. 移除链表元素
 *
 * @author zhangyu
 * Date: 6/5/21
 * @since JDK 1.8
 */
public class Solution0203 {

    public static void main(String[] args) {
        Solution0203 solution = new Solution0203();
        ListNode.print(solution.removeElements(ListNode.buildFromArray(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        ListNode.print(solution.removeElements(ListNode.buildFromArray(new int[]{}), 1));
        ListNode.print(solution.removeElements(ListNode.buildFromArray(new int[]{7, 7, 7, 7}), 7));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1, head), pre = tmp;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return tmp.next;
    }
}
