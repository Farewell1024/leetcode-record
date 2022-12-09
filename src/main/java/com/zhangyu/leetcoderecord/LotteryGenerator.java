package com.zhangyu.leetcoderecord;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 4/18/22
 * @since JDK 1.8
 */
public class LotteryGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generate());
        }
    }

    public static Lottery generate() {
        Random random = new Random();
        Set<Integer> redBalls = new HashSet<>();
        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(redBalls);
        Collections.sort(list);
        return new Lottery(list, random.nextInt(16) + 1);
    }

    @Data
    @AllArgsConstructor
    public static class Lottery {
        private List<Integer> redBalls;
        private Integer blueBall;

        @Override
        public String toString() {
            return "Red Balls: " + redBalls +
                    ", Blue Ball: [" + blueBall + "]";
        }
    }

}
