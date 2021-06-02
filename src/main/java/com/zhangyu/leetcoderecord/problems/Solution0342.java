package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 342. 4的幂
 *
 * @author zhangyu
 * Date: 5/31/21
 * @since JDK 1.8
 */
public class Solution0342 {

    public static void main(String[] args) {
        Solution0342 solution = new Solution0342();
        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(1));
    }

    public boolean isPowerOfFour2(int n) {
//        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) == n;
//        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
        return n > 0 && (n & (n - 1)) == 0 && n % 3 ==1;
    }

    public boolean isPowerOfFour(int n) {
        switch (n) {
            case 1 :
            case 4 :
            case 16 :
            case 64 :
            case 256 :
            case 1024 :
            case 4096 :
            case 16384 :
            case 65536 :
            case 262144 :
            case 1048576 :
            case 4194304 :
            case 16777216 :
            case 67108864 :
            case 268435456 :
            case 1073741824 : return true;
            default: return false;
        }
    }
}
