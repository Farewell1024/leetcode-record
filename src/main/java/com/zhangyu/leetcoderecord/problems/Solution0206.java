package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

import static com.zhangyu.leetcoderecord.utils.ListNode.buildFromArray;
import static com.zhangyu.leetcoderecord.utils.ListNode.print;

/**
 * Function:  206. 反转链表
 *
 * @author zhangyu
 * Date: 2020/10/15 13:53
 * @since JDK 1.8
 */
public class Solution0206 {

    public static void main(String[] args) {
        Solution0206 solution = new Solution0206();
        print(solution.reverseList(buildFromArray(new int[]{1, 2, 3, 4, 5})));
    }

    public ListNode reverseList(ListNode head) {
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


}
