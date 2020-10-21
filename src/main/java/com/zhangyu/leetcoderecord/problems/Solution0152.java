package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 152. 乘积最大子数组
 *
 * @author zhangyu
 * Date: 2020/10/21 18:17
 * @since JDK 1.8
 */
public class Solution0152 {

    public static void main(String[] args) {
        Solution0152 solution = new Solution0152();
        System.out.println(solution.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(solution.maxProduct(new int[]{-2,0,-1}));
    }

    public int maxProduct(int[] nums) {
        int[] max = new int[2], min = new int[2];
        int result = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = i % 2, y = (i - 1) % 2;
            max[x] = Math.max(Math.max(max[y] * nums[i], min[y] * nums[i]), nums[i]);
            min[x] = Math.min(Math.min(max[y] * nums[i], min[y] * nums[i]), nums[i]);
            result = Math.max(result, max[x]);
        }
        return result;
    }

}
