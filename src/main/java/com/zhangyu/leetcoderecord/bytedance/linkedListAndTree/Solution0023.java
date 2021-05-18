package com.zhangyu.leetcoderecord.bytedance.linkedListAndTree;

import com.zhangyu.leetcoderecord.utils.ListNode;

import static com.zhangyu.leetcoderecord.utils.ListNode.print;

/**
 * Function: 23. 合并K个升序链表
 *
 * @author zhangyu
 * Date: 2021/3/16 09:39
 * @since JDK 1.8
 */
public class Solution0023 {

    public static void main(String[] args) {
        Solution0023 solution = new Solution0023();
        print(solution.mergeKLists(new ListNode[]{
                ListNode.buildFromArray(new int[]{1, 4, 5}),
                ListNode.buildFromArray(new int[]{1, 3, 4}),
                ListNode.buildFromArray(new int[]{2, 6})
        }));
        print(solution.mergeKLists(new ListNode[0]));
        print(solution.mergeKLists(new ListNode[]{null}));

    }

    /**
     * 分治 将每两个链表合成一个
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return mergeTwo(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
    }

    public ListNode mergeTwo(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.val < second.val) {
            first.next = mergeTwo(first.next, second);
            return first;
        } else {
            second.next = mergeTwo(second.next, first);
            return second;
        }
    }

}
