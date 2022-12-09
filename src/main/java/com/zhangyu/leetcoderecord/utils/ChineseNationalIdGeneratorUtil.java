package com.zhangyu.leetcoderecord.utils;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.base.GenericGenerator;

import java.time.LocalDate;
import java.util.Random;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 7/13/21
 * @since JDK 1.8
 */
public class ChineseNationalIdGeneratorUtil {

    private static final Random RANDOM = new Random();

    private static final int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    private static final char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("110101");
        sb.append(LocalDate.now().getYear() - (RANDOM.nextInt(35) + 25));
//        sb.append()
        sb.append("20161110");
        sb.append(String.format("%03d", RANDOM.nextInt(1000)));
        sb.append(calcTrailingNumber(sb.toString().toCharArray()));
        return sb.toString();
    }

    private static char calcTrailingNumber(char[] chars) {
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        return r[result % 11];
    }

    public static void main(String[] args) {
        GenericGenerator instance = ChineseIDCardNumberGenerator.getInstance();
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
        System.out.println(instance.generate());
    }
}
