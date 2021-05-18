package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;


import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 21. 合并两个有序链表
 *
 * @author zhangyu
 * Date: 2021/3/9 09:42
 * @since JDK 1.8
 */
public class Solution0021 {

    public static void main(String[] args) {
        Solution0021 solution = new Solution0021();
        ListNode.print(solution.mergeTwoLists(
                ListNode.buildFromArray(new int[]{1, 2, 4}),
                ListNode.buildFromArray(new int[]{1, 3, 4})
        ));
        ListNode.print(solution.mergeTwoLists(null, null));
        ListNode.print(solution.mergeTwoLists(null, new ListNode(1)));
    }

    /**
     * 官方解法2：迭代
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了25.06%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了9.17%的用户
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * 递归
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了25.06%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了46.38%的用户
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        }
    }

}
