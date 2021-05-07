package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 1486. 数组异或操作
 *
 * @author zhangyu
 * Date: 2021/5/7
 * @since JDK 1.8
 */
public class Solution1486 {

    public static void main(String[] args) {
        Solution1486 solution = new Solution1486();
        System.out.println(solution.xorOperation(5, 0));
        System.out.println(solution.xorOperation(4, 3));
        System.out.println(solution.xorOperation(1, 7));
        System.out.println(solution.xorOperation(10, 5));
    }

    /**
     * 元素排列顺序为 start,start+2,start+4...
     * result记录结果，初始为start
     */
    public int xorOperation(int n, int start) {
        int result =  start;
        for (int i = 1; i < n; i++) {
            start += 2;
            result ^= start;
        }
        return result;
    }
}
