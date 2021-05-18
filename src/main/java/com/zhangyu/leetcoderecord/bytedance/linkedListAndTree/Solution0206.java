package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import com.zhangyu.leetcoderecord.utils.ListNode;

import static com.zhangyu.leetcoderecord.utils.ListNode.buildFromArray;
import static com.zhangyu.leetcoderecord.utils.ListNode.print;

/**
 * Function: 206. 反转链表
 *
 * @author zhangyu
 * Date: 2021/3/10 10:38
 * @since JDK 1.8
 */
public class Solution0206 {

    public static void main(String[] args) {
        Solution0206 solution = new Solution0206();
        print(solution.reverseList(buildFromArray(new int[]{1, 2, 3, 4, 5})));
    }

    /**
     * 递归
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了41.19%的用户
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 迭代
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了43.37%的用户
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

}
