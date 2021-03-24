package com.zhangyu.leetcoderecord.bytedance.strings;

/**
 * Function: 43. 字符串相乘
 * TODO 官方解法试试
 * @author zhangyu
 * Date: 2021/3/22 09:33
 * @since JDK 1.8
 */
public class Solution0043 {

    public static void main(String[] args) {
        Solution0043 solution = new Solution0043();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("2000", "0"));
        System.out.println(solution.multiply("123", "456"));
    }

    /**
     *
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int c1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                StringBuilder sb = new StringBuilder();
                int c2 = num2.charAt(j) - '0';
                sb.append(c1 * c2);
                for (int k = i+j; k < num1.length() + num2.length() - 2; k++){
                    sb.append(0);
                }
                result = addStrings(result, sb.toString());
            }
        }
        return result;
    }

    /**
     * 两数相加
     */
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
             i >=0 || j >= 0 || carry > 0; i--, j--){
            int x = i < 0 ? 0 : (num1.charAt(i) - '0');
            int y = j < 0 ? 0 : (num2.charAt(j) - '0');
            int r = x + y + carry;
            sb.append(r % 10);
            carry = r / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * 自我解法。超过int最大值就失效了
     */
    public String multiplyTest(String num1, String num2) {
        // a longer than b
        String a, b;
        if (num1.length() > num2.length()) {
            a = num1;
            b = num2;
        } else {
            a = num2;
            b = num1;
        }
        int result = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            int cur2 = (b.charAt(i) - '0');
            int subResult = 0;
            for (int j = a.length() - 1; j >= 0; j--) {
                int cur1 = (a.charAt(j) - '0');
                int c = cur2 * cur1;
                for (int k = j; k < a.length() - 1; k++)
                    c *= 10;
                subResult += c;
            }
            for (int l = i; l < b.length() - 1; l++) {
                subResult *= 10;
            }
            result += subResult;
        }
        return result + "";
    }

}
