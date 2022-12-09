package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 374. 猜数字大小
 *
 * @author zhangyu
 * Date: 6/14/21
 * @since JDK 1.8
 */
public class Solution0374 {

    public static void main(String[] args) {
        Solution0374 solution = new Solution0374();
        System.out.println(solution.guess(10));
    }

    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int guess(int num) {
        return Integer.compare(num, 6);
    }
}
