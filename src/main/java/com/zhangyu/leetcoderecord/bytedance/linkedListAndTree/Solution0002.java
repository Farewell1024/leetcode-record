package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import com.zhangyu.leetcoderecord.utils.ListNode;

/**
 * Function: 2. 两数相加
 *
 * @author zhangyu
 * Date: 2021/3/11 09:32
 * @since JDK 1.8
 */
public class Solution0002 {

    public static void main(String[] args) {
        Solution0002 solution = new Solution0002();
        ListNode.print(solution.addTwoNumbers(
                ListNode.buildFromArray(new int[]{2, 4, 3}),
                ListNode.buildFromArray(new int[]{5, 6, 4})
        ));
        ListNode.print(solution.addTwoNumbers(new ListNode(0), new ListNode(0)));
        ListNode.print(solution.addTwoNumbers(
                ListNode.buildFromArray(new int[]{9, 9, 9, 9, 9, 9, 9}),
                ListNode.buildFromArray(new int[]{9, 9, 9, 9})
        ));
    }

    /**
     * 按照正常思维，从头到尾依次相加，需要进位就进位
     * 都相加完后需要进位的话，就新建一个节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1), result = tmp;
        int a = 0;
        while (l1 != null || l2 != null) {
            int b = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + a;
            a = b / 10;
            tmp.next = new ListNode(b % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            tmp = tmp.next;
        }
        if (a != 0) tmp.next = new ListNode(a);
        return result.next;
    }

}
