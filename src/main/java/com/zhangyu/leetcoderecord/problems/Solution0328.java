package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 328. 奇偶链表
 *
 * @author zhangyu
 * Date: 2020/11/13 09:31
 * @since JDK 1.8
 */
public class Solution0328 {

    public static void main(String[] args) {
        Solution0328 solution = new Solution0328();
        ListNode.print(solution.oddEvenList(ListNode.buildFromArray(new int[]{1, 2, 3, 4, 5})));
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

}
