package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 278. 第一个错误的版本
 *
 * @author zhangyu
 * Date: 6/13/21
 * @since JDK 1.8
 */
public class Solution0278 {

    public static void main(String[] args) {
        Solution0278 solution = new Solution0278();
        System.out.println(solution.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }

}
