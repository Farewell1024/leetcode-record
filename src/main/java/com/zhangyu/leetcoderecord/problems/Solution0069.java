package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 69. x 的平方根
 *
 * @author zhangyu
 * Date: 2020/10/21 17:20
 * @since JDK 1.8
 */
public class Solution0069 {

    public static void main(String[] args) {
        Solution0069 solution = new Solution0069();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(9));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0;
        int right = x;
        int result = 0;
        while (left <= right) {
            int middle = left + (right - left) /2;
            if (middle > x / middle) {
                right = middle-1;
            } else if (middle < x/ middle){
                left = middle+1;
                result = middle;
            } else {
                return middle;
            }
        }
        return result;
    }
}
