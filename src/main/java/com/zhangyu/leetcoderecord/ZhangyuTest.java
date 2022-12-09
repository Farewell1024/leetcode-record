package com.zhangyu.leetcoderecord;

import com.zhangyu.leetcoderecord.utils.ListNode;
import lombok.Getter;
import lombok.Setter;


/**
 * Function:
 *
 * @author zhangyu
 * Date: 2021/5/25
 * @since JDK 1.8
 */
public class ZhangyuTest {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (1 << 30) % n == 0;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode skipA = headA, skipB = headB;
        while (skipA != skipB) {
            skipA = skipA == null ? headB : skipA.next;
            skipB = skipB == null ? headA : skipB.next;
        }
        return skipA;

    }
}
