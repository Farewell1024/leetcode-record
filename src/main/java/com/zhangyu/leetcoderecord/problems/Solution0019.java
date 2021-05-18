package com.zhangyu.leetcoderecord.problems;

import com.zhangyu.leetcoderecord.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Function: 19. 删除链表的倒数第N个节点
 *
 * @author zhangyu
 * Date: 2020/10/15 14:15
 * @since JDK 1.8
 */
public class Solution0019 {

    public static void main(String[] args) {
        Solution0019 solution = new Solution0019();
        ListNode.print(solution.removeNthFromEnd(ListNode.buildFromArray(new int[]{1,2,3,4,5}), 2));
    }

    /**
     * 采用Map计数 删除指定倒数元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 1;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            map.put(count++, tmpNode);
            tmpNode = tmpNode.next;
        }
        map.put(count -n, null);
        if (map.get(count -n - 1) == null) {
            return map.get(count -n + 1);
        }else {
            map.get(count -n - 1).next = map.get(count -n + 1);
            return map.get(1);
        }
    }

    /**
     * 快慢指针。快指针比慢指针快N。
     * 当快指针到头的时候，慢指针就到了要删除的这个元素
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode quick = prev;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        ListNode slow = prev;
        while (quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prev.next;
    }

}
