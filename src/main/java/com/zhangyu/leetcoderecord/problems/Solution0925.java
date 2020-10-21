package com.zhangyu.leetcoderecord.problems;

/**
 * Function:  925. 长按键入
 *
 * @author zhangyu
 * Date: 2020/10/21 10:10
 * @since JDK 1.8
 */
public class Solution0925 {

    public static void main(String[] args) {
        Solution0925 solution = new Solution0925();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(solution.isLongPressedName("leelee", "lleeelee"));
        System.out.println(solution.isLongPressedName("laiden", "laiden"));
    }

    /**
     * 官方解法 双指针
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }
        int i=0, j=0;
        while (j < typed.length()) {
            if (i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if (j > 0 && typed.charAt(j-1)==typed.charAt(j)){
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

}
