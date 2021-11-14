package com.js.effectivejava.item59;

import java.util.Random;

public class RandomProblem {

    static Random random = new Random();

    static int random(int n) {
        return Math.abs(random.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }

        System.out.println(low);
    }
}
