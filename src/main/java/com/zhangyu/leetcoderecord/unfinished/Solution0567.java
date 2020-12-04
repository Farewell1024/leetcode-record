package com.zhangyu.leetcoderecord.unfinished;

/**
 * Function: 567. 字符串的排列
 *
 * @author zhangyu
 * Date: 2020/11/27 09:52
 * @since JDK 1.8
 */
public class Solution0567 {

    public static void main(String[] args) {
        Solution0567 solution = new Solution0567();
//        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
//        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int count = s1.length();
        int[] cahce = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cahce[s1.charAt(i) - 'a'] ++;
        }
        boolean flag = false;
        for (int i = 0; i < s2.length(); i++) {
            if (!flag && cahce[s2.charAt(i) - 'a'] > 0) {
                flag = true;
                cahce[s2.charAt(i) - 'a'] --;
                count -- ;
                continue;
            }
            if (flag) {
                if (cahce[s2.charAt(i) - 'a'] <= 0) {
                    break;
                } else {
                    cahce[s2.charAt(i) - 'a'] --;
                    count -- ;
                }
            }
        }
        return count == 0;
    }

}
